package com.equipe4.apptest.journey

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import com.equipe4.apptest.R
import com.equipe4.apptest.network.nomatim.NominatimResult
import com.equipe4.apptest.network.nomatim.NominatimServiceFactory
import com.equipe4.apptest.UserProfileActivity
import com.equipe4.apptest.messaging.MessagerieList
import com.equipe4.apptest.network.app.AppServiceFactory
import com.equipe4.apptest.network.navitia.NavitiaServiceFactory
import com.equipe4.apptest.network.navitia.models.journeys.Journey
import com.equipe4.apptest.network.navitia.models.journeys.JourneyResult
import kotlinx.android.synthetic.main.activity_journey_screen1.*
import kotlinx.android.synthetic.main.activity_journey_screen2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_journey_screen2.bottom_bar
import retrofit2.http.Body

class JourneyScreen2 : AppCompatActivity() {

    companion object{
        private val JOURNEY_SEARCH_EXTRA = "journey_search"

        fun createIntent(context: Context, journeySearch: JourneySearch):Intent{
            val intent = Intent(context , JourneyScreen2::class.java)
            intent.putExtra(JOURNEY_SEARCH_EXTRA, journeySearch)
            return intent
        }
    }

    val nominatimSeervice = NominatimServiceFactory().getNominatimService()
    val journeyService = NavitiaServiceFactory().getJourneyService()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_screen2)

        val searchedJourney = intent.getParcelableExtra<JourneySearch>(JOURNEY_SEARCH_EXTRA)

        if(searchedJourney is JourneySearch){
            //AutoComplete search
            editText_input_searched_journey_start.setText(searchedJourney.startPoint)
            editText_input_searched_journey_end.setText(searchedJourney.endPoint)

            // RETRIEVE COORDINATES FOR STARTPOINT
            nominatimSeervice.findNominatimCoord(searchedJourney.startPoint)
                .enqueue(object : Callback<List<NominatimResult>>{
                    override fun onResponse(call: Call<List<NominatimResult>>,responseStart: Response<List<NominatimResult>>
                    ) {
                        val startBody = responseStart.body()
                        if(!responseStart.isSuccessful || (startBody is List<NominatimResult> && startBody.isEmpty())){
                            Toast.makeText(applicationContext, getString(R.string.str_journey_nominatim_error), Toast.LENGTH_LONG).show()
                            finish()
                            return
                        }
                        val startLon = responseStart.body()?.get(0)?.lon
                        val startLat = responseStart.body()?.get(0)?.lat

                        //RETRIEVE COORDINATES FOR ENDPOINT
                        nominatimSeervice.findNominatimCoord(searchedJourney.endPoint)
                            .enqueue(object : Callback<List<NominatimResult>>{
                                override fun onResponse(
                                    call: Call<List<NominatimResult>>,
                                    responseEnd: Response<List<NominatimResult>>
                                ) {
                                    val endBody = responseEnd.body()
                                    if(!responseEnd.isSuccessful || (endBody is List<NominatimResult> && endBody.isEmpty())){
                                        Toast.makeText(applicationContext, getString(R.string.str_journey_nominatim_error), Toast.LENGTH_LONG).show()
                                        finish()
                                        return
                                    }
                                    val endLon = responseEnd.body()?.get(0)?.lon
                                    val endLat = responseEnd.body()?.get(0)?.lat

                                    //IT'S TIME FOR NAVITIA ! o/
                                    val journeys = journeyService.findJourneys(
                                        "75a4bdfa-263f-48cf-9664-bc011e10ffdd",
                                        "fr-idf",
                                        "${startLon};${startLat}",
                                        "${endLon};${endLat}"
                                    ).enqueue(object: Callback<JourneyResult>{
                                        override fun onResponse(
                                            call: Call<JourneyResult>,
                                            response: Response<JourneyResult>
                                        ) {
                                            if(!response.isSuccessful){
                                                Toast.makeText(applicationContext, getString(R.string.str_journey_navitia_nojourney_error),Toast.LENGTH_LONG).show()
                                                finish()
                                                return
                                            }
                                            println("YAY")
                                            println(response)
                                        }

                                        //IF NAVITIA JOURNEY REQUEST FAILS
                                        override fun onFailure(call: Call<JourneyResult>,t: Throwable) {
                                            Toast.makeText(applicationContext, getString(R.string.str_journey_nominatim_error), Toast.LENGTH_LONG).show()
                                        }
                                    })
                                }

                                //IF END POINT COORD REQUEST FAILS
                                override fun onFailure(
                                    call: Call<List<NominatimResult>>,
                                    t: Throwable
                                ) {
                                    Toast.makeText(applicationContext, getString(R.string.str_journey_nominatim_error), Toast.LENGTH_LONG).show()
                                }
                            })
                    }

                    //IF START POINT COORD REQUEST FAILS
                    override fun onFailure(call: Call<List<NominatimResult>>, t: Throwable) {
                        Toast.makeText(applicationContext, getString(R.string.str_journey_nominatim_error), Toast.LENGTH_LONG).show()
                        finish()
                    }

                }
                )

        }else{
            Toast.makeText(applicationContext, getText(R.string.str_journey_empty_search_error), Toast.LENGTH_LONG).show()
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val profileIntent = Intent(this, UserProfileActivity::class.java)
        val messageIntent = Intent(this, MessagerieList::class.java)

        when (item!!.itemId) {
            R.id.app_bar_profile -> startActivity(profileIntent)
            R.id.app_bar_messages -> startActivity(messageIntent)
        }
        return true
    }

}
