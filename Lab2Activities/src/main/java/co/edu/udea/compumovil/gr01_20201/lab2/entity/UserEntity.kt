package co.edu.udea.compumovil.gr01_20201.lab2.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class UserEntity (
    @PrimaryKey
    @ColumnInfo(name = "User")
    val user: String?,

    @ColumnInfo(name = "names")
    val name: String?,

    @ColumnInfo(name = "email")
    val email : String?,

    @ColumnInfo(name = "password")
    val password : String?,

    @ColumnInfo(name = "country")
    val country : String?,

    @ColumnInfo(name = "date")
    val date : Date?,

    @ColumnInfo(name = "gender")
    val gender : String?,

    )