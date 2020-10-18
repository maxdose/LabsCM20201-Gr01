package co.edu.udea.compumovil.gr01_20201.lab2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import co.edu.udea.compumovil.gr01_20201.lab2.entity.UserEntity

@Dao
interface UserDAO {
    @Query("SELECT * FROM userentity")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM userentity WHERE user IN (:users)")
    fun loadAllByIds(users: ArrayList<String>): List<UserEntity>

    @Query("SELECT * FROM userentity WHERE names LIKE :names")
    fun findByName(names: String): UserEntity

    @Insert
    fun insertAll(vararg users: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}