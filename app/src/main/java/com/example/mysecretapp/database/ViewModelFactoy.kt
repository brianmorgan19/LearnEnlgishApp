package com.example.mysecretapp.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactoy(val reposetory: UserReposetory): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelUser(reposetory) as T
    }

}