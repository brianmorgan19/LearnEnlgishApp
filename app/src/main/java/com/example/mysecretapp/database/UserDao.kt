package com.example.mysecretapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user:User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user:User)

    @Query("SELECT * FROM user_table WHERE user_email=:name")
    fun getName(name:String): String{
        return name
    }

    @Query("SELECT EXISTS(SELECT * FROM user_table WHERE user_email=:useremail AND user_password=:password)")
    fun getUser(useremail:String, password:String) : Boolean

}