package com.kcdeepak.faceapp

import androidx.room.*


@Dao
interface UserFaceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFaceUser(userFace: UserFace)

    @Query("select * from user_face order by id asc")
    fun readAllUsers():List<UserFace>

    @Delete
    fun deleteFaceUser(userFace: UserFace)
}