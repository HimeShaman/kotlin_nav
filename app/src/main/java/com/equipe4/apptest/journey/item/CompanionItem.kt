package com.equipe4.apptest.journey.item

import android.view.View
import com.equipe4.apptest.R
import com.equipe4.apptest.journey.viewholder.CompanionViewHolder
import com.equipe4.apptest.network.app.journeys.JourneyCompanion
import com.mikepenz.fastadapter.items.AbstractItem

class CompanionItem (val companion: JourneyCompanion): AbstractItem<CompanionViewHolder>() {
    override val layoutRes: Int
        get() = R.layout.row_companion
    override val type: Int
        get() = R.id.text_view_companion_name

    override fun getViewHolder(v: View): CompanionViewHolder {
        return CompanionViewHolder(v)
    }
}