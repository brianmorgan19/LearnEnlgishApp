package com.example.mysecretapp.signupin

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.mysecretapp.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.main_login_activity.*

class LoginActivity : AppCompatActivity() {

    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager:ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_login_activity)

        val loginFragment = login_fragment()
        val signupFragment = signup_fragment()
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager2>(R.id.view_pager)

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){tab,pos->
            tab.text = when(pos){
                0 -> "ВОЙТИ"
                1 -> "РЕГИСТРАЦИЯ"
                else -> throw Resources.NotFoundException("pos isn't found")
            }
        }.attach()
    }
}
