package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R

class SubscriptionScreen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen2)
    }

    //TODO : factorize "go to next screen" function
    //TODO : finish() previous activity
    //TODO : send inputs to next activity

    fun goToSubscribe3(view: View) {

        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")

        val intent = Intent(this, SubscriptionScreen3::class.java)

        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)

        startActivity(intent)

    }
}