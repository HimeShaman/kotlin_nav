package com.equipe4.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.equipe4.apptest.journey.JourneyScreen1
import com.equipe4.apptest.network.app.AppServiceFactory
import com.equipe4.apptest.network.app.users.UserLogin
import com.equipe4.apptest.network.app.users.UsersService
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import android.widget.TextView
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActionBar()?.hide()
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_login)
    }

    private val usersService:UsersService = AppServiceFactory().getUserLoginService()


    fun login(view: View){
        usersService.login()
            .enqueue(object: Callback<UserLogin>{
                override fun onResponse(call: Call<UserLogin>, response: Response<UserLogin>) {
                    if (textInputEditText_Login_email.text.toString() != response.body()?.email
                        || textInputEditText_Login_password.text.toString() != response.body()?.password ){
                        Toast.makeText(applicationContext,getString(R.string.str_login_false), Toast.LENGTH_LONG).show()
                    } else {
                        val intent = Intent(this@LoginActivity, JourneyScreen1::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

                override fun onFailure(call: Call<UserLogin>, t: Throwable) {
                    Toast.makeText(applicationContext, getString(R.string.str_login_failed), Toast.LENGTH_LONG).show()
                    println(t.message)
                }
            } )
    }
}
