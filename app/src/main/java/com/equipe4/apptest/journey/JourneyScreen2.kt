package com.equipe4.apptest.journey

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.activity_journey_screen2.*

class JourneyScreen2 : AppCompatActivity() {

    companion object{
        private val JOURNEY_SEARCH_EXTRA = "journey_search"

        fun createIntent(context: Context, journeySearch: JourneySearch):Intent{
            val intent = Intent(context , JourneyScreen2::class.java)
            intent.putExtra(JOURNEY_SEARCH_EXTRA, journeySearch)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_screen2)

        val searchedJourney = intent.getParcelableExtra<JourneySearch>(JOURNEY_SEARCH_EXTRA)

        if(searchedJourney is JourneySearch){
            editText_input_searched_journey_start.setText(searchedJourney.startPoint)
            editText_input_searched_journey_end.setText(searchedJourney.endPoint)
        }
    }

}
