package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_subscription_screen1.*

class SubscriptionScreen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen1)
    }

    fun goToSubscribe2(view: View){
        val firstName:String = textInputEditText_firstName.text.toString()
        val lastName:String = textInputEditText_lastName.text.toString()
        if (firstName == ""){
            textInputEditText_firstName.error = getString(R.string.error_emptyInput)
        }

//        Checks if firstName & lastName are empty to display error/go to next screen
        if(lastName == ""){
            textInputEditText_lastName.error = getString(R.string.error_emptyInput)
        }
        if (firstName != "" && lastName != "" )
        {
            textInputEditText_firstName.error = null
            textInputEditText_lastName.error = null
            val intent = Intent(this, SubscriptionScreen2::class.java)
            startActivity(intent)
        }
    }
}
