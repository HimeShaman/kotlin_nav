package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_subscription_screen5.*


class SubscriptionScreen5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen5)
    }

    fun goToSubscribe6 (view: View) {

        val password = textInputEditText_password
        val passwordString = textInputEditText_password.toString()

//        Checks if email isn't empty and is in right format to display error

        if ( passwordString.isEmpty())
        {
            textInputEditText_password.error = getString(R.string.error_emptyInput)
        }

        if (password.length() < 8){
            textInputEditText_password.error = getString(R.string.error_shortPassword)
        }

//        No errors, go to next screen

        if (password.length() >= 8) {
            val intent = Intent(this, SubscriptionScreen6::class.java)
            startActivity(intent)
        }
    }
}