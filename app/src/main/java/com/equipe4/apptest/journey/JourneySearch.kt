package com.equipe4.apptest.journey

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JourneySearch(
    val startPoint:String,
    val endPoint:String,
    val optionTrain:Boolean,
    val optionBus:Boolean,
    val optionMetro:Boolean,
    val optionTram:Boolean
):Parcelable

