package com.equipe4.apptest.network.navitia.models.lines

data class LinesResult(
    val lines:List<Lines>,
    val pagination: Pagination
) {
}