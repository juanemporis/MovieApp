package com.example.movie.Actividades


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.MovieAdapter
import com.example.movie.R
import com.example.movie.models.Movie
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







    //SE REALIZO EL CAMBIO DE ACTIVIDADES
        val boton1=findViewById<Button>(R.id.buton1)
        boton1.setOnClickListener {
            val lanzar = Intent(this,ActivityFavorite::class.java)
            startActivity(lanzar)
        }

//SE REALIZO LA LISTA DE PELICULAS
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

    private fun callback(movies: List<Movie>) {

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_drawer,menu)
        return super.onCreateOptionsMenu(menu)
    }


    }






















