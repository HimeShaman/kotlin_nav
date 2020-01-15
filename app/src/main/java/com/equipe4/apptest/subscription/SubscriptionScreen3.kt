package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_subscription_screen3.*

class SubscriptionScreen3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen3)
    }

    fun goToSubscribe4(view: View) {

        val ageInput : String = textInputEditText_age.text.toString()

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
                startActivity(intent)
            }
        }

    }
}
