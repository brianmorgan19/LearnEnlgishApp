package com.example.mysecretapp.database

class UserReposetory(val db: UserDB) {

    suspend fun upsert(user:User) = db.getAllDAO().upsert(user)

}