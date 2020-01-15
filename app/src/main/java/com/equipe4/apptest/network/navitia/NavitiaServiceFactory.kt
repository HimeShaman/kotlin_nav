package com.equipe4.apptest.network.navitia

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NavitiaServiceFactory {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.navitia.io/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLinesService(): LinesService {
        return retrofit.create(LinesService::class.java)
    }

}