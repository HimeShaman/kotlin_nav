package com.equipe4.apptest.network.navitia.models

data class LinesResult(
    val lines:List<Lines>,
    val pagination:Pagination
) {
}