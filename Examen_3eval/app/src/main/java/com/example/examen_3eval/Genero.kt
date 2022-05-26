package com.example.examen_3eval


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genero(private val genero: String?) : Parcelable {

    override fun toString() = "$genero"

}