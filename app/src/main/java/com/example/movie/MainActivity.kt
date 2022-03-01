package com.example.movie

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.models.MovieResponse
import com.example.movie.service.APIService
import com.example.movie.service.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movie : List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movie)
        }

    }

    private fun getMovieData(callback: (List<Movie>) ->Unit){
        val apiService = MovieApiService.getIntance().create(APIService::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse>{


            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)

            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })

    }

}