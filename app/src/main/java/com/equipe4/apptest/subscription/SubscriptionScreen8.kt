package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R

class SubscriptionScreen8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionBar()?.hide()
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_subscription_screen8)
    }

    fun goToSubscribe9 (view: View){

        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")
        val gender : String? = intent.getStringExtra("gender")
        val age : String? = intent.getStringExtra("age")
        val email : String? = intent.getStringExtra("email")
        val bio : String? = intent.getStringExtra("bio")

        val intent = Intent(this, SubscriptionScreen9::class.java)

        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)
        intent.putExtra("gender", gender)
        intent.putExtra("age", age)
        intent.putExtra("email", email)
        intent.putExtra("bio", bio)

        startActivity(intent)
    }
}
