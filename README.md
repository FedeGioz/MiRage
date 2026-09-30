# MiRage

Android app to drive and monitor a [MiR](https://mobile-industrial-robots.com/) autonomous mobile robot from a phone.

I built it in 2025 as my final project at ITIS Mario Delpozzo (Cuneo). The school's MiR robot comes with a web interface that is slow and awkward to use from a phone, so I wanted something you can actually use while walking next to the robot. I presented it at the state exam and showed it to visitors at the school open days.

## Features

- Login with the robot's user accounts (same credentials as the web interface), remembered between sessions
- Live status bar: robot state, battery level, connection
- On-screen joystick to drive the robot manually
- List the maps stored on the robot and switch the active one
- List missions and add them to the mission queue
- List the robot's sounds, play them on the robot or preview them on the phone

## How it talks to the robot

The robot exposes two interfaces, and the app uses both.

**REST API** (`http://<robot-ip>/api/v2.0.0`) for status, maps, missions and sounds. Login uses HTTP Basic auth, where the password is sent as its SHA-256 hash, the same way the web interface does it.

**rosbridge WebSocket** (`ws://<robot-ip>:9090`) for everything real time. Manual driving is not part of the public REST API, and I couldn't find it documented anywhere, so I worked it out by watching the web interface's WebSocket traffic in Chrome DevTools. The flow is:

1. Ask the robot for a joystick token by calling the `/mir/get_joystick_token` service
2. Switch the robot to manual mode through the `/mirsupervisor/setRobotState` service
3. Publish velocity commands on the `/joystick_vel` topic, signed with the token

```json
{
  "op": "publish",
  "topic": "/joystick_vel",
  "msg": {
    "joystick_token": "<token>",
    "speed_command": {
      "linear":  { "x": 0.4, "y": 0, "z": 0 },
      "angular": { "x": 0, "y": 0, "z": 0.2 }
    }
  }
}
```

Sounds are played the same way, through the `/mir_sound` service. The WebSocket client reconnects on its own with an increasing delay if the connection drops.

## Tech stack

- Kotlin Multiplatform with Compose Multiplatform (Android is the main target, the iOS target is only partially implemented)
- Ktor client for REST and WebSocket, kotlinx.serialization
- Jetpack Navigation, DataStore for the saved login

## Running it

1. Open the project in Android Studio and run the `composeApp` configuration on a phone
2. Connect the phone to the robot's Wi-Fi network
3. The robot address is set in `ApiClient.kt` and `RobotWebSocketClient.kt` (`192.168.12.20` is the MiR default)

## Related projects

MiRage was later split into two apps for the school's orientation days:

- **[MirOrientatore](https://github.com/FedeGioz/MirOrientatore)**: teacher app. It drives the robot through a guided tour and runs a WebSocket server for the students' phones.
- **[MirOriento](https://github.com/FedeGioz/MirOriento)**: student app. It connects to the teacher's device, receives quizzes and can take over the joystick when the teacher allows it.

## Known limitations

- The robot IP is hardcoded
- The diagnostics screen is only a placeholder
- Tested only on the school's robot

MiRage is a personal project and is not affiliated with Mobile Industrial Robots.
