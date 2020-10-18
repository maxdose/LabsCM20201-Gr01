package co.edu.udea.compumovil.gr01_20201.lab2.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class POIEntity (
    @PrimaryKey
    val poiId: Int,

    @ColumnInfo(name = "namePOI")
    val namePOI: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "puntuation")
    val puntuation: String?,

)
