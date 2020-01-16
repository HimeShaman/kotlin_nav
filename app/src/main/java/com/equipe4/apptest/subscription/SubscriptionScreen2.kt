package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R

class SubscriptionScreen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionBar()?.hide()
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_subscription_screen2)
    }

    //TODO : factorize "go to next screen" function
    //TODO : finish() previous activity
    //TODO : send inputs to next activity


    fun maleGoToSubscribe3(view: View) {
        val gender = "Homme"
        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")

        val intent = Intent(this, SubscriptionScreen3::class.java)

        intent.putExtra("gender", gender)
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)

        startActivity(intent)
    }

    fun femaleGoToSubscribe3(view: View) {

        val gender = "Femme"
        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")

        val intent = Intent(this, SubscriptionScreen3::class.java)

        intent.putExtra("gender", gender)
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)

        startActivity(intent)
    }
}