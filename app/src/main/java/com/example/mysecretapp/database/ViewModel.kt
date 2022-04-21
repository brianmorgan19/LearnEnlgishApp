package com.example.mysecretapp.database

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewModelUser(val reposetory: UserReposetory): ViewModel(){

    fun upsert(user:User) = CoroutineScope(Dispatchers.Main).launch{
        reposetory.upsert(user)
    }
}