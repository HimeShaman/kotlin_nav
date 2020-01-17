package com.equipe4.apptest.network.app.journeys

import com.google.gson.annotations.SerializedName

data class JourneyCompanion(
    val name:String,
    val age:Int,
    val rate:Int,
    @SerializedName("nb_avis")
    val nbAvis:Int,
    @SerializedName("journey_time")
    val journeyTime:String,
    val description:String
)