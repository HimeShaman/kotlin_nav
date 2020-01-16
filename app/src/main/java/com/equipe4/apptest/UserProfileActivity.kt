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
        val lastName = sharedPreferences.getString("lastName", "")
        val gender = sharedPreferences.getString("gender", "")
        val age = sharedPreferences.getString("age", "")
        val email = sharedPreferences.getString("email", "")
        val bio = sharedPreferences.getString("bio", "")

        val firstNameTextView : TextView = findViewById(R.id.text_view_firstName)
        val lastNameTextView : TextView = findViewById(R.id.text_view_lastName)
        val genderTextView : TextView = findViewById(R.id.text_view_gender)
        val ageTextView : TextView = findViewById(R.id.text_view_age)
        val emailTextView : TextView = findViewById(R.id.text_view_email)
        val bioTextView : TextView = findViewById(R.id.text_view_bio)

        firstNameTextView.text = firstName
        lastNameTextView.text = lastName
        genderTextView.text = gender
        ageTextView.text = age
        emailTextView.text = email
        bioTextView.text = bio

    }
}
