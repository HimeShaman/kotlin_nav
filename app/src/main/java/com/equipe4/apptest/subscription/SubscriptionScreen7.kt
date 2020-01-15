package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R


class SubscriptionScreen7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen7)
    }

    fun goToSubscribe8(view: View){

        val intent = Intent(this, SubscriptionScreen8::class.java)
        startActivity(intent)
    }
}
