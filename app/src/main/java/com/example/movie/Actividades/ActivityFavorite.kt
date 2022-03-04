package com.example.movie.Actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.movie.R

class ActivityFavorite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)


        val boton2 = findViewById<Button>(R.id.buton2)
        boton2.setOnClickListener {
            val lanzar = Intent(this, MainActivity::class.java)
            startActivity(lanzar)
        }
    }
}