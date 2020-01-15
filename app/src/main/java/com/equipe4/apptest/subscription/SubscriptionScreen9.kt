package com.equipe4.apptest.subscription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.equipe4.apptest.R
import android.widget.TextView

class SubscriptionScreen9 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen9)

        val bio = intent.getStringExtra("bio")
        val email = intent.getStringExtra("email")
        val age = intent.getStringExtra("age")
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val view = findViewById(R.id.text_view_alert) as TextView
        view.text = firstName + "||" + lastName + "||" + age + "||" + bio + "||" + email + "||" + age

        finish()
    }
}
