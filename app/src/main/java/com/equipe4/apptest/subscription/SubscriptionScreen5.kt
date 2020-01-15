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

    //TODO : factorize "go to next screen" function
    //TODO : finish() previous activity
    //TODO : send inputs to next activity
    fun goToSubscribe6 (view: View) {

        val password = textInputEditText_password
        val passwordString = textInputEditText_password.toString()
        val email : String? = intent.getStringExtra("email")
        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")
        val age : String? = intent.getStringExtra("age")

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

            intent.putExtra("email", email)
            intent.putExtra("age", age)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)

            startActivity(intent)
        }
    }
}