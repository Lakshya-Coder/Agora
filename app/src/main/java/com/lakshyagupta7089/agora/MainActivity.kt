package com.lakshyagupta7089.agora

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       d(Runnable {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 2000)
    }
}