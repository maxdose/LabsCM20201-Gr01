package co.edu.udea.compumovil.gr01_20201.lab2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import co.edu.udea.compumovil.gr01_20201.lab2.entity.POIEntity
import co.edu.udea.compumovil.gr01_20201.lab2.entity.UserEntity

@Dao
interface POIDAO {
    @Query("SELECT * FROM poientity")
    fun getAll(): List<POIEntity>

    @Query("SELECT * FROM poientity WHERE poiId IN (:poiIds)")
    fun loadAllByIds(poiIds: IntArray): List<POIEntity>

    @Query("SELECT * FROM poientity WHERE namePOI LIKE :namesPOI")
    fun findByName(namesPOI: String): POIEntity

    @Insert
    fun insertAll(vararg poiIds: POIEntity)

    @Delete
    fun delete(poiId: POIEntity)
}