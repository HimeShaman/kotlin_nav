package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_subscription_screen2.*
import kotlinx.android.synthetic.main.activity_subscription_screen3.*

class SubscriptionScreen3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionBar()?.hide()
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_subscription_screen3)

    }

    //TODO : factorize "go to next screen" function
    //TODO : finish() previous activity
    //TODO : send inputs to next activity
    fun goToSubscribe4(view: View) {

        val ageInput : String = textInputEditText_age.text.toString()
        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")
        val gender : String? = intent.getStringExtra("gender")


//        Checks if age is empty to display error

        if (ageInput.isEmpty()){
            textInputEditText_age.error = getString(R.string.error_emptyInput)
        }

//        If not empty, check if age is more than 16

        if(ageInput.isNotEmpty()) {

            var age : Int = ageInput.toInt()

            if (age < 16) {
                textInputEditText_age.error = getString(R.string.error_invalidAge)
            }

//        No errors, go to next screen

            if (age >= 16)
            {
                textInputEditText_age.error = null
                val intent = Intent(this, SubscriptionScreen4::class.java)

                intent.putExtra("age", ageInput)
                intent.putExtra("firstName", firstName)
                intent.putExtra("lastName", lastName)
                intent.putExtra("gender", gender)

                startActivity(intent)
            }
        }

    }
}
