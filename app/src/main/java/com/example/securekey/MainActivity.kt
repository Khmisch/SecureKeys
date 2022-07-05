package com.example.securekey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var serverKey = BuildConfig.SERVER_KEY
    var smsKey = BuildConfig.SMS_KEY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var application = Application()
        Log.d("@@@MainActivity", serverKey)
        Log.d("@@@MainActivity", smsKey)
        Log.d("@@@MainActivity", application.getPublicKey().toString())
        Log.d("@@@MainActivity", application.getPrivateKey().toString())
    }
}