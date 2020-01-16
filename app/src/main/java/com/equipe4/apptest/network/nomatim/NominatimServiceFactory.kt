package com.equipe4.apptest.network.nomatim

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NominatimServiceFactory {
    //Calling Nominatim to get coordinates matching the searched terms for journeys
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://nominatim.openstreetmap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //Users request
    fun getNominatimService(): NominatimService {
        return retrofit.create(NominatimService::class.java)
    }
}