package com.federicogiordano.mirage.ui

expect class AudioPlayer() {
    fun playSound(url: String)
    fun release()
}