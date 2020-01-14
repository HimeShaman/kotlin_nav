package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_subscription_screen1.*

class SubscriptionScreen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen1)
    }

    fun onNext(){
        val firstName:String = textInputEditText_firstName.toString()
        val lastName:String = textInputEditText_lastName.toString()
        if (firstName === ""){
            textInputEditText_firstName.error = getString(R.string.error_emptyInput)
        } else if(lastName === ""){
            textInputEditText_firstName.error = getString(R.string.error_emptyInput)
        }else{
            textInputEditText_firstName.error = null
            textInputEditText_lastName.error = null
            val intent = Intent(this, SubscriptionScreen1::class.java)
            startActivity(intent)
        }
    }
}
