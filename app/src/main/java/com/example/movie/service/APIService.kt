package com.example.movie.service

import com.example.movie.models.MovieResponse
import retrofit2.http.GET
import retrofit2.Call

interface APIService {

    @GET("/3/movie/popular?api_key=2d53775ecfd27395dcc879ca50019fa1")

    fun getMovieList(): Call<MovieResponse>
}