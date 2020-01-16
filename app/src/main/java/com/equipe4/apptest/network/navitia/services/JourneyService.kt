package com.equipe4.apptest.network.navitia.services

import com.equipe4.apptest.network.navitia.models.journeys.JourneyResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface JourneyService {
    @GET("coverage/{region}/journeys")
    fun findJourneys(@Header("Authorization") authorization:String,
                  @Path("region") region:String,
                  @Query("from") from:String,
                  @Query("to") to:String
    ): Call<JourneyResult>
}