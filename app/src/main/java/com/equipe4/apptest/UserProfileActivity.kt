package com.equipe4.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val sharedPreferences = getSharedPreferences("profilePreferences", 0)
        val firstName = sharedPreferences.getString("firstName", "")

        val textView : TextView = findViewById(R.id.text_view_firstName)
        textView.text = firstName
    }
}
