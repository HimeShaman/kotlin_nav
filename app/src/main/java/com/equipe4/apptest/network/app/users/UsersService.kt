package com.equipe4.apptest.network.app.users


import retrofit2.Call
import retrofit2.http.GET

interface UsersService {
    //login-check
    @GET("user_login.json")
    fun login(): Call<UserLogin>
}