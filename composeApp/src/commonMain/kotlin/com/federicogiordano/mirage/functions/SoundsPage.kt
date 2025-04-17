package com.federicogiordano.mirage.functions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material.icons.filled.Speaker
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.federicogiordano.mirage.data.RobotSound
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.federicogiordano.mirage.RobotWebSocketClient
import com.federicogiordano.mirage.api.SoundsService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoundsList(navController: NavHostController){
    var sounds by remember { mutableStateOf<List<RobotSound>>(emptyList()) }
    var selectedSound by remember { mutableStateOf<RobotSound?>(null) }

    LaunchedEffect(Unit) {
        sounds = SoundsService().getSounds()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            "Sounds List",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (sounds.isEmpty()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn {
                items(sounds) { sound ->
                    SoundItem(
                        sound = sound,
                        onClick = {
                            selectedSound = sound
                        }
                    )
                }
            }
        }
    }
    
    if(selectedSound != null){
        AlertDialog(
            icon = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(Icons.Default.Speaker, contentDescription = "Play sound")
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            selectedSound = null
                        }
                    ){
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            },
            title = {
                Text(text = "Play sound")
            },
            text = {
                Text(text = "Do you want to play the sound on the robot or on the device?")
            },
            onDismissRequest = {},
            confirmButton = {
                IconButton(
                    onClick = {
                        RobotWebSocketClient().sendSoundPlayRequest(selectedSound!!.guid)
                    }
                ) {
                    Icon(Icons.Filled.SmartToy, contentDescription = "Robot")
                }
            },
            dismissButton = {
                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(Icons.Filled.Phone, contentDescription = "Phone")
                }
            },
        )
    }
}


@Composable
fun SoundItem(sound: RobotSound, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = sound.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Guid: ${sound.guid}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}