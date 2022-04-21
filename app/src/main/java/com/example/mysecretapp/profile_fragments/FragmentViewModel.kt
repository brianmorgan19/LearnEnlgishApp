package com.example.mysecretapp.profile_fragments

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {
    val data = MutableLiveData<Uri>()

    fun setImage(image: Uri?){
        data.value = image!!
    }
}