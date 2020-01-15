package com.equipe4.apptest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 1500

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()

        }, SPLASH_TIME_OUT)
    }


}