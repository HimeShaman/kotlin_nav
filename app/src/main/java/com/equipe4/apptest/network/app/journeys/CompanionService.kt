package com.equipe4.apptest.network.app.journeys

import retrofit2.Call
import retrofit2.http.GET

interface CompanionService {
    //get companion for journey
    @GET("journey_companions.json")
    fun findCompanionsByJourney(): Call<List<JourneyCompanion>>
}