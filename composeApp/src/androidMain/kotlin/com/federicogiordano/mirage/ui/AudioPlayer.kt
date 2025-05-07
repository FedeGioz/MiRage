package com.federicogiordano.mirage.ui

import android.content.Context
import android.media.MediaPlayer

actual class AudioPlayer {
    private var mediaPlayer: MediaPlayer? = null

    actual fun playSound(url: String) {
        release()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(url)
            prepare()
            start()
        }
    }

    actual fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}