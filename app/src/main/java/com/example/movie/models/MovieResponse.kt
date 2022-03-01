package com.example.movie.models

import android.graphics.Movie
import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize


data class MovieResponse (
    @SerializedName("results")
    val movies : List<Movie>

     ):Parcelable {
         constructor() : this(mutableListOf())

    }

