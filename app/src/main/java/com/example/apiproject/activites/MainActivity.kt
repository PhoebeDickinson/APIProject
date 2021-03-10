package com.example.apiproject.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apiproject.R
import com.example.apiproject.helpers.FilmAdapter
import com.example.apiproject.services.FilmService
import com.example.apiproject.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import com.example.apiproject.modles.GhibliFilm as GhibliFilm

class MainActivity : AppCompatActivity() {

    private val TAG = "mainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ///START HERE!!!!!

        film_recycler.adapter = FilmAdapter(emptyList<GhibliFilm>())
        film_recycler.layoutManager

        film_recycler.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity,2)}


        loadFilm()
    }

    private fun loadFilm() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(FilmService::class.java)
        val requestCall = destinationService.getMovie()
        //make network call asynchronously
        requestCall.enqueue(object : retrofit2.Callback<List<GhibliFilm>> {
            override fun onResponse(call: Call<List<GhibliFilm>>, response: Response<List<GhibliFilm>> ) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val film  = response.body() ?:
                    Log.d("Response", "Movie : " + response.body())
                    film_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = FilmAdapter(response.body()!!)
                    }
                    Toast.makeText(this@MainActivity, "this should have done somthing", Toast.LENGTH_SHORT).show()

                }else{
                    Log.d("Response", "onResponse: FAILED in onResponse")
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<GhibliFilm>> , t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
                Log.d("Failure", "onResponse: FAILED in onfailure" + t.message)
            }
        })
    }
}