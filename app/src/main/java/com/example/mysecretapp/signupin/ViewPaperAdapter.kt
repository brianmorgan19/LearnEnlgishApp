package com.example.mysecretapp.signupin

import android.content.Context
import android.content.res.Resources
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mysecretapp.R

class ViewPagerAdapter(val fm: FragmentActivity): FragmentStateAdapter(fm) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> login_fragment()
            1 -> signup_fragment()
            else -> throw Resources.NotFoundException("pos isn't found")
        }
    }
}