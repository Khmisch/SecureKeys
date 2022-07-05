package com.example.securekey

import android.app.Application

class Application : Application() {

    init {
//        System.loadLibrary("keys")
        System.loadLibrary("native-lib")
    }

    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?
}