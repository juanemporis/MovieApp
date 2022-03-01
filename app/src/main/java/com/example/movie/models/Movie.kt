package com.example.movie.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Movie(

    @SerializedName("id")
    val id :String?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("release_date")
    val release: String?,

    ): Parcelable{
        constructor(): this("","","","")

    }


