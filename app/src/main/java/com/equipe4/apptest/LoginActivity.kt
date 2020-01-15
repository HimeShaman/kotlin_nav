package com.equipe4.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.equipe4.apptest.network.app.AppServiceFactory
import com.equipe4.apptest.network.app.users.UserLogin
import com.equipe4.apptest.network.app.users.UsersService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    private val usersService:UsersService = AppServiceFactory().getUserLoginService()


    fun login(view: View){
    usersService.login()
            .enqueue(object: Callback<UserLogin>{
                override fun onResponse(call: Call<UserLogin>, response: Response<UserLogin>) {
                   print(response.body()?.email)
                    Toast.makeText(applicationContext, response.body()?.email, Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<UserLogin>, t: Throwable) {
                    Toast.makeText(applicationContext, "Nous n'avons pas pu te connecter :(", Toast.LENGTH_LONG).show()
                    println(t.message)
                }
            } )

//        if(userResponse.isSuccessful){
//            print(userResponse.body()?.email)
//            print(userResponse.body()?.password)
//            Toast.makeText(this, "Email:${userResponse.body()?.email} " +
//                    "& pass:${userResponse.body()?.password}", Toast.LENGTH_LONG).show()
//        }
    }
}
