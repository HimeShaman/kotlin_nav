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
        val ageString:String = textInputEditText_age.text.toString()
        val age = ageString.toInt()

        if (age < 16) {
            textInputEditText_age.error = getString(R.string.error_invalidAge)
        }

        if (ageString == ""){
            textInputEditText_age.error = getString(R.string.error_emptyInput)
        }

        if (ageString != "" && age >= 16) {
            textInputEditText_age.error = null
            val intent = Intent(this, SubscriptionScreen4::class.java)
            startActivity(intent)
        }
    }
}
