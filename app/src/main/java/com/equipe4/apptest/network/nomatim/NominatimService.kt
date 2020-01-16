package com.equipe4.apptest.network.nomatim

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NominatimService {
    @GET("/?format=json&addressdetails=1&")
    fun findNominatimCoord(
        @Query("q") q:String
    ): Call<List<NominatimResult>>
}