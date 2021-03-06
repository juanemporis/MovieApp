package com.example.movie

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_list.view.*



class MovieAdapter (

    private val movies : List<com.example.movie.models.Movie>
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        fun bindMovie(movie : com.example.movie.models.Movie){
            itemView.movie_title.text = movie.title
            itemView.movie_release_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster ).into(itemView.movie_poster)



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list,parent,false)
        )

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))

    }

    override fun getItemCount(): Int = movies.size



    }



