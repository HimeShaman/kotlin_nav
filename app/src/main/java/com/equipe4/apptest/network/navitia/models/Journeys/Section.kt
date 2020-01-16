package com.equipe4.apptest.network.navitia.models.journeys

import com.google.gson.annotations.SerializedName

data class Section(
    val mode: String?,
    val type: String?,
    @SerializedName("display_informations")
    val displayInformations: DisplayInformations?
)