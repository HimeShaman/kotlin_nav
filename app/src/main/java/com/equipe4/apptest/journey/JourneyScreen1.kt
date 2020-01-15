package com.equipe4.apptest.journey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_journey_screen1.*

class JourneyScreen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_screen1)
    }

    fun doSearch(view:View){
        val searchedJourney = JourneySearch(
            editText_input_journey_start.text.toString(),
            editText_input_journey_end.text.toString(),
            journey_checkbox1_train.isChecked,
            journey_checkbox2_bus.isChecked,
            journey_checkbox3_metro.isChecked ,
            journey_checkbox4_tram.isChecked
        )

        val intentSearch = JourneyScreen2.createIntent(this,searchedJourney)
        startActivity(intentSearch)
        //No finish in order to modify search criteria if journeys aren't satisfying to the user
    }
}
