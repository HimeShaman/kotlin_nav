package com.equipe4.apptest.network.app

import com.equipe4.apptest.network.app.users.UsersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppServiceFactory {

    //Faking API calls behaviour
    // TODO: To be replaced when the back-end is developed
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.hetic-mobile.benedicte-quimbert.fr/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //Users request
    fun getUserLoginService():UsersService{
        return retrofit.create(UsersService::class.java)
    }

}