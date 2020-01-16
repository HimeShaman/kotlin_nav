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
import kotlinx.android.synthetic.main.activity_journey_screen1.*
import kotlinx.android.synthetic.main.activity_journey_screen2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_journey_screen2.bottom_bar

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_screen2)

        val searchedJourney = intent.getParcelableExtra<JourneySearch>(JOURNEY_SEARCH_EXTRA)

        if(searchedJourney is JourneySearch){
            //AutoComplete search
            editText_input_searched_journey_start.setText(searchedJourney.startPoint)
            editText_input_searched_journey_end.setText(searchedJourney.endPoint)

            //Retrieve coordinates for startPoint
            nominatimSeervice.findNominatimCoord(searchedJourney.startPoint)
                .enqueue(object : Callback<List<NominatimResult>>{
                    override fun onResponse(call: Call<List<NominatimResult>>,responseStart: Response<List<NominatimResult>>
                    ) {
                      val startLon = responseStart.body()?.get(0)?.lon
                      val startLat = responseStart.body()?.get(0)?.lat

                        //Retrieve coordinates for endPoint
                        val responseEnd = nominatimSeervice.findNominatimCoord(searchedJourney.endPoint).execute()
                        if(responseEnd.isSuccessful){
                            val endLon = responseEnd.body()?.get(0)?.lon
                            val endLat = responseEnd.body()?.get(0)?.lat
                        }else{
                            Toast.makeText(applicationContext, getString(R.string.str_journey_nominatim_error), Toast.LENGTH_LONG).show()
                        }

                    }
                    override fun onFailure(call: Call<List<NominatimResult>>, t: Throwable) {
                        //TODO
                       println(t)
                    }

                }
            )

        }else{
            Toast.makeText(applicationContext, "Et mes adresses alors ?", Toast.LENGTH_LONG).show()
//            finish()
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
