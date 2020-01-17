package com.equipe4.apptest.journey

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equipe4.apptest.R
import com.equipe4.apptest.UserProfileActivity
import com.equipe4.apptest.journey.item.CompanionItem
import com.equipe4.apptest.journey.item.JourneyItem
import com.equipe4.apptest.messaging.MessagerieList
import com.equipe4.apptest.network.app.AppServiceFactory
import com.equipe4.apptest.network.app.journeys.JourneyCompanion
import com.equipe4.apptest.network.navitia.models.journeys.JourneyResult
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_journey_screen2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class JourneyScreen3 : AppCompatActivity() {


    companion object{
        private val JOURNEY_SEARCH_EXTRA = "journey_search"

        fun createIntent(context: Context, journeySearch: JourneySearch): Intent {
            val intent = Intent(context , JourneyScreen3::class.java)
            intent.putExtra(JOURNEY_SEARCH_EXTRA, journeySearch)
            return intent
        }
    }

    val companionService = AppServiceFactory().getCompanionService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_screen3)

        //Retrieve search
        val searchedJourney = intent.getParcelableExtra<JourneySearch>(JourneyScreen3.JOURNEY_SEARCH_EXTRA)

        if(searchedJourney is JourneySearch){
            //AutoComplete search
            editText_input_searched_journey_start.setText(searchedJourney.startPoint)
            editText_input_searched_journey_end.setText(searchedJourney.endPoint)
        }

        companionService.findCompanionsByJourney().enqueue(object: Callback<List<JourneyCompanion>>{
            override fun onResponse(call: Call<List<JourneyCompanion>>, response: Response<List<JourneyCompanion>>) {
                if(response.body() is List<JourneyCompanion>){

                    //BUILDING COMPANIONS LIST
                    val itemAdapter = ItemAdapter<CompanionItem>()
                    val companionResult = response.body()
                    if(companionResult is List<JourneyCompanion>) {
                        itemAdapter.add(companionResult.map { CompanionItem(it) })
                    }
                    val fastAdapter = FastAdapter.with(itemAdapter)
                    journey_recycler_view.layoutManager = LinearLayoutManager(this@JourneyScreen3)

                    journey_recycler_view.addItemDecoration(
                        DividerItemDecoration(this@JourneyScreen3, RecyclerView.VERTICAL)
                    )

                    journey_recycler_view.adapter = fastAdapter
                }
            }

            override fun onFailure(call: Call<List<JourneyCompanion>>, t: Throwable) {
                Toast.makeText(applicationContext, getString(R.string.str_login_failed), Toast.LENGTH_LONG).show()
                println(t.message)
            }
        } )
    }


    //Menu
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
