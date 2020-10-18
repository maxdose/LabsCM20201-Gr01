package co.edu.udea.compumovil.gr01_20201.lab2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.edu.udea.compumovil.gr01_20201.lab2.dao.UserDAO
import co.edu.udea.compumovil.gr01_20201.lab2.entity.POIEntity
import co.edu.udea.compumovil.gr01_20201.lab2.entity.UserEntity

@Database(entities = arrayOf(UserEntity::class, POIEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
}