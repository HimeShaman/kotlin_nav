package com.equipe4.apptest.journey.item

import android.view.View
import com.equipe4.apptest.R
import com.equipe4.apptest.journey.viewholder.JourneyViewHolder
import com.equipe4.apptest.network.navitia.models.journeys.Journey
import com.mikepenz.fastadapter.items.AbstractItem

class JourneyItem (val journey: Journey): AbstractItem<JourneyViewHolder>() {
    override val layoutRes: Int
        get() = R.layout.row_journey
    override val type: Int
        get() = R.id.text_view_companion_name

    override fun getViewHolder(v: View): JourneyViewHolder {
        return JourneyViewHolder(v)
    }
}
