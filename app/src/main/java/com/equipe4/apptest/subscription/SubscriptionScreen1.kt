package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.equipe4.apptest.MainActivity
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
        if(lastName == ""){
            textInputEditText_lastName.error = getString(R.string.error_emptyInput)
        }
        if(lastName != "" && firstName!="")
        {
            textInputEditText_firstName.error = null
            textInputEditText_lastName.error = null
//            TODO : change intent to next screen when created instead of going back to Main
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
