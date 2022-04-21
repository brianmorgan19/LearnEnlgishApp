package com.example.mysecretapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.mysecretapp.profile_fragments.FragmentViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: FragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setFragment(secondFragment)


        buttons.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.icMessage -> setFragment(firstFragment)
                R.id.icHome -> setFragment(secondFragment)
                R.id.icProfile -> setFragment(thirdFragment)
            }
            true
        }

    }

    fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }


}