package com.example.apiproject.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.R
import com.example.apiproject.modles.GhibliFilm
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_film.view.*

class FilmAdapter(private val film: List<GhibliFilm>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //which layout is it?
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return film.size

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d("Response", "List Count :${film.size} ")


        return holder.bind(film[position])

    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        /*var title = itemView.findViewById<TextView>(R.id.filmName)
        var description = itemView.findViewById<TextView>(R.id.filmDescription)
        var director = itemView.findViewById<TextView>(R.id.filmDirector)
        var producer = itemView.findViewById<TextView>(R.id.filmProducer)*/

        //links object to layout fields
        fun bind(film: GhibliFilm) {

            val title = "Title: " + film.title

            itemView.filmName.text = title
            itemView.filmDescription.text = "Plot: " + film.description
            itemView.filmDirector.text = "Directed by: " + film.director
            itemView.filmProducer.text = "Produced by: " + film.producer

            /*title.text = film.title
            description.text = film.description
            director.text = film.director
            producer.text = film.producer*/

        }

    }
}