package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R

class SubscriptionScreen6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen6)
    }

    fun goToSubscribe7(view: View){

        val intent = Intent(this, SubscriptionScreen7::class.java)
        startActivity(intent)

    }
}
