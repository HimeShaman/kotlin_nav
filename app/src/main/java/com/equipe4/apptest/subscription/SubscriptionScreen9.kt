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
        setContentView(R.layout.activity_subscription_screen9)

        val sharedPreferences = this.getSharedPreferences("profilePreferences", 0)
        val editor = sharedPreferences!!.edit()

        val firstName : String? = intent.getStringExtra("firstName")

        editor.putString("firstName", firstName)
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
