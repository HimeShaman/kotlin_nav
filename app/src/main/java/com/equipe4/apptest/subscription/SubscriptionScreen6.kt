package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R

import android.widget.TextView

class SubscriptionScreen6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen6)
    }

    fun goToSubscribe7(view: View){

        val email : String? = intent.getStringExtra("email")
        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")
        val age : String? = intent.getStringExtra("age")

        val intent = Intent(this, SubscriptionScreen7::class.java)

        intent.putExtra("email", email)
        intent.putExtra("age", age)
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)

        startActivity(intent)
    }
}
