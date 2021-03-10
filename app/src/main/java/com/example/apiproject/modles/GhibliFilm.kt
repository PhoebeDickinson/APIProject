package com.example.apiproject.modles

data class GhibliFilm(
    val id: String,
    val title: String,
    val description: String,
    val director: String,
    val producer: String,

    //@Json(name = "release_date")
    val releaseDate: String,

    //@Json(name = "rt_score")
    val rtScore: String,

    val people: List<String>,
    val species: List<String>,
    val locations: List<String>,
    val vehicles: List<String>,
    val url: String
) {}

