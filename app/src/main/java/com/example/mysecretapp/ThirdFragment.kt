package com.example.mysecretapp

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.mysecretapp.profile_fragments.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.fragment_third.view.*


class ThirdFragment : Fragment(R.layout.fragment_third) {

    var displayName: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_third, container, false)

        val tablayout = view.findViewById<TabLayout>(R.id.profie_tablayout)
        val viewpager = view.findViewById<ViewPager2>(R.id.profie_viewpager)

        tablayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = FragmentAdapter(requireActivity())
        viewpager.adapter = adapter

        TabLayoutMediator(tablayout, viewpager){tab, pos ->
            tab.text = when(pos){
                0 -> "Профиль"
                1 -> "Настройки"
                else -> throw Resources.NotFoundException("not found tab")
            }
        }.attach()

        tablayout.getTabAt(0)?.setIcon(R.drawable.profile)
        tablayout.getTabAt(1)?.setIcon(R.drawable.setting2)

        return view
    }

}