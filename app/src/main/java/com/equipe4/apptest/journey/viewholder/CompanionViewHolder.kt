package com.equipe4.apptest.journey.viewholder

import android.view.View
import com.equipe4.apptest.journey.item.CompanionItem
import com.mikepenz.fastadapter.FastAdapter
import kotlinx.android.synthetic.main.row_companion.view.*

class CompanionViewHolder(itemView: View) : FastAdapter.ViewHolder<CompanionItem>(itemView) {
    override fun bindView(item: CompanionItem, payloads: MutableList<Any>) {
       itemView.text_view_companion_name.text = item.companion.name
        itemView.text_view_companion_time.text = item.companion.journeyTime


    }

    override fun unbindView(item: CompanionItem) {
        itemView.text_view_companion_name.text = null
        itemView.text_view_companion_time.text = null
    }


}