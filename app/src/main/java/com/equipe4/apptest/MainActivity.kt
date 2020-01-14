package com.equipe4.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.equipe4.apptest.subscription.SubscriptionScreen1
import kotlinx.android.synthetic.main.activity_subscription_screen1.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToSubscribe1(view: View){
        val intent = Intent(this, SubscriptionScreen1::class.java)
        startActivity(intent)
    }
}
