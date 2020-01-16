package com.equipe4.apptest.network.navitia.models.journeys

import com.google.gson.annotations.SerializedName

data class DisplayInformations(
    val code:String,
    val color:String,
    @SerializedName("text_color")
    val textcolor:String
) {
}