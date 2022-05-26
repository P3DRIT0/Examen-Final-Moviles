package com.example.examen_3eval
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Info(private val nom_cancion: String?, private val autor: String?, private val ruta: Int, private val des: Int) : Parcelable {

    override fun toString() = "$nom_cancion/$autor/$ruta/$des"

}
