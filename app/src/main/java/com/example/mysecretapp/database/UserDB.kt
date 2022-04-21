package com.example.mysecretapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1
)
abstract class UserDB(): RoomDatabase() {

    abstract fun getAllDAO(): UserDao

    companion object {
        @Volatile
        var instanse: UserDB? = null

        fun getDataBase(context: Context): UserDB {
            val tempInstanse = instanse
            if (tempInstanse != null) {
                return tempInstanse
            }
            synchronized(this) {
                val INSTANSE = Room.databaseBuilder(context.applicationContext, UserDB::class.java, "db.db").build()
                instanse = INSTANSE
                return INSTANSE
            }
        }
    }
}