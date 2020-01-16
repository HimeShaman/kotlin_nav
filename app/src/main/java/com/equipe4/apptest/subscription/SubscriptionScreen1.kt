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
        getActionBar()?.hide()
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_subscription_screen1)
    }

    //TODO : factorize "go to next screen" function
    //TODO : finish() previous activity
    //TODO : send inputs to next activity
    fun goToSubscribe2(view: View){

        val firstName:String = textInputEditText_firstName.text.toString()
        val lastName:String = textInputEditText_lastName.text.toString()

//        Checks if firstName & lastName are empty to display error

        if (firstName.isEmpty()){
            textInputEditText_firstName.error = getString(R.string.error_emptyInput)
        }

        if(lastName.isEmpty()){
            textInputEditText_lastName.error = getString(R.string.error_emptyInput)
        }

//        No errors, go to next screen

        if (firstName.isNotEmpty() && lastName.isNotEmpty())
        {
            textInputEditText_firstName.error = null
            textInputEditText_lastName.error = null
            val intent = Intent(this, SubscriptionScreen2::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            startActivity(intent)

            finish()
        }
    }
}
