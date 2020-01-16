package com.equipe4.apptest.network.navitia.models.journeys

data class Journey (
   val sections: List<Section>,
   val duration: Int
){
}