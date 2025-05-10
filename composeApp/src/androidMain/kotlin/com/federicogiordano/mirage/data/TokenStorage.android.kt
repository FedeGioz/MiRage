package com.federicogiordano.mirage.data

import android.content.Context
import okio.Path.Companion.toPath

// Store context as a global variable to be initialized at app start
lateinit var appContext: Context

actual fun getDataStoreFile(fileName: String): okio.Path {
    return appContext.filesDir.resolve(fileName).absolutePath.toPath()
}