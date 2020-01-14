package com.equipe4.apptest.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_subscription_screen4.*

class SubscriptionScreen4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription_screen4)
    }

    fun goToSubscribe5(view: View) {
        val intent = Intent(this, SubscriptionScreen5::class.java)
        startActivity(intent)
    }
}
