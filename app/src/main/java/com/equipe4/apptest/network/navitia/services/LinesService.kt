package com.equipe4.apptest.network.navitia.services

import com.equipe4.apptest.network.navitia.models.lines.LinesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface LinesService {
    @GET("coverage/{region}/lines?")
    fun findLines(@Path("region") region:String,
                  @Header("Authorization") authorization:String
    ): Call<LinesResult>

}