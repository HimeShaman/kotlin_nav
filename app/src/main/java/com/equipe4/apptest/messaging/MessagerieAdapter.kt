package com.equipe4.apptest.messaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.equipe4.apptest.R
import kotlinx.android.synthetic.main.messagerie_list_row.view.*

class MessagerieAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    val names = listOf<String>("Lou Gloaguen", "Jessica Poulain", "Eloise Isautier", "Bénédicte Quimbert", "Mika Stark", "Lissandre Pasdeloup", "Leïla Chiban")
    val messages = listOf<String>("Merci pour le trajet c'était super !", "Merci, à demain.", "C'est vraiment gentil à vous.", "On a bien ri avant-hier !", "Super moment avec vous :)", "Trop cool la sortie d'hier", "On ne se reverra pas la semaine prochaine :(")
    val dates = listOf<String>("à 13h37", "Hier", "28/12/2019", "12/12/2019", "30/11/2019", "29/11/2019", "25/11/2019")
    //number of items
    override fun getItemCount(): Int {
        return names.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.messagerie_list_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val name = names.get(position)
        val date = dates.get(position)
        val message = messages.get(position)

        holder.view.nameView.text = name
        holder.view.lastMessageDate.text = date
        if (message.length > 32){
            holder.view.lastMessageView.text = message.substring(0,29).plus("...")
        }else{
            holder.view.lastMessageView.text = message
        }
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}