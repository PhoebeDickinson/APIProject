package com.example.apiproject.services

import com.example.apiproject.modles.GhibliFilm
import retrofit2.Call
import retrofit2.http.GET

interface FilmService {
    @GET("films/")
    fun getMovie() : Call<List<GhibliFilm>>
}