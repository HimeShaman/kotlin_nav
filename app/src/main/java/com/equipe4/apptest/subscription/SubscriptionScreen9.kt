package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import com.equipe4.apptest.LoginActivity
import com.equipe4.apptest.UserProfileActivity

class SubscriptionScreen9 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionBar()?.hide()
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_subscription_screen9)

        val sharedPreferences = this.getSharedPreferences("profilePreferences", 0)
        val editor = sharedPreferences!!.edit()

        val firstName : String? = intent.getStringExtra("firstName")
        val lastName : String? = intent.getStringExtra("lastName")
        val gender : String? = intent.getStringExtra("gender")
        val age : String? = intent.getStringExtra("age")
        val email : String? = intent.getStringExtra("email")
        val bio : String? = intent.getStringExtra("bio")

        editor.putString("firstName", firstName)
        editor.putString("lastName", lastName)
        editor.putString("gender", gender)
        editor.putString("age", age)
        editor.putString("email", email)
        editor.putString("bio", bio)

        editor.apply()
    }

    fun goToUserProfile(view: View) {
        val intent = Intent(this, UserProfileActivity::class.java)
        startActivity(intent)
    }

    /*fun goToConnexion(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }*/
}
