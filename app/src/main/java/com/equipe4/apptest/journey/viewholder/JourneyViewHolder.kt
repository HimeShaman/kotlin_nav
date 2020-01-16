package com.equipe4.apptest.journey.viewholder

import android.graphics.Color
import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.equipe4.apptest.R
import com.equipe4.apptest.journey.item.JourneyItem
import com.equipe4.apptest.network.navitia.models.journeys.DisplayInformations
import com.equipe4.apptest.network.navitia.models.journeys.Section
import com.mikepenz.fastadapter.FastAdapter
import kotlinx.android.synthetic.main.row_journey.view.*

class JourneyViewHolder(itemView: View) : FastAdapter.ViewHolder<JourneyItem>(itemView) {
    override fun bindView(item: JourneyItem, payloads: MutableList<Any>) {
        val journey = item.journey

        val hours = journey.duration/3600
        val minutes = (journey.duration%3600)/60
        val seconds = (journey.duration%60)
        itemView.text_view_time.text = "${hours}h ${minutes}min ${seconds}s"

        if(journey.sections.isNotEmpty()){
            val section1 = journey.sections.first()
            buildSection(itemView.imageView1, itemView.textView1, section1)

            if (journey.sections.size > 1){
                val section2 = journey.sections[1]
                buildSection(itemView.imageView2, itemView.textView2, section2)

                if (journey.sections.size > 2){
                    val section3 = journey.sections[2]
                    buildSection(itemView.imageView3, itemView.textView3, section3)

                    if (journey.sections.size > 3){
                        val section4 = journey.sections[3]
                        buildSection(itemView.imageView4, itemView.textView4, section4)
                    }
                }
            }

        }



    }

    override fun unbindView(item: JourneyItem) {
        itemView.text_view_time.text = null
        itemView.textView1.visibility = View.INVISIBLE
        itemView.textView2.visibility = View.INVISIBLE
        itemView.textView3.visibility = View.INVISIBLE
        itemView.textView4.visibility = View.INVISIBLE
        itemView.imageView1.visibility = View.INVISIBLE
        itemView.imageView2.visibility = View.INVISIBLE
        itemView.imageView3.visibility = View.INVISIBLE
        itemView.imageView4.visibility = View.INVISIBLE
    }

    private fun buildSection(image: ImageView, text: TextView, section: Section){
        println(section)
        image.visibility = View.VISIBLE
        if(section.mode == "walking"){
            image.setImageResource(R.drawable.ic_walk)
            text.visibility = View.INVISIBLE
        }else{
            text.visibility = View.VISIBLE
            image.setImageResource(R.drawable.cirleshape)
            var sectionColor = "454545"
            if(section.displayInformations is DisplayInformations){
                sectionColor = section.displayInformations.color
                text.text = section.displayInformations.code
                text.setTextColor(Color.parseColor("#${section.displayInformations.textcolor}"))
            }
            image.setColorFilter(Color.parseColor("#$sectionColor"))


        }
    }
}