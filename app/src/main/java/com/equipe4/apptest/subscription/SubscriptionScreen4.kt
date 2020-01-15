package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_subscription_screen4.*

class SubscriptionScreen4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen4)
    }

    //TODO : factorize "go to next screen" function
    //TODO : finish() previous activity
    //TODO : send inputs to next activity
    fun goToSubscribe5(view: View) {

        val email = textInputEditText_email.text.toString()
        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")
        val age : String? = intent.getStringExtra("age")

//        Checks if email isn't empty and is in right format

        if (email.isEmpty()){
            textInputEditText_email.error = getString(R.string.error_emptyInput)
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textInputEditText_email.error = getString(R.string.error_invalidEmail)
        }

//        No errors, go to next screen

        if(email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            val intent = Intent(this, SubscriptionScreen5::class.java)

            intent.putExtra("email", email)
            intent.putExtra("age", age)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)

            startActivity(intent)
        }
    }
}
