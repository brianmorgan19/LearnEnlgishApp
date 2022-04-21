package com.example.mysecretapp.profile_fragments

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mysecretapp.R
import kotlinx.android.synthetic.main.change_name.*

class CHANGE(): AppCompatActivity(){
    lateinit var edittext1:EditText
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.change_name)





    }
}