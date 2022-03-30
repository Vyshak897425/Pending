package com.example.simpleproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import androidx.viewpager2.widget.ViewPager2
import com.example.simpleproject1.adapters.ViewPagerAdapter
import com.example.simpleproject1.fragments.SecondFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        //val secondFragment = SecondFragment()
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransition : FragmentTransaction = fragmentManager.beginTransaction()
       // fragmentTransition.replace(R.id.view_pager_2,adapter.createFragment(1)).commit()




        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "First"
                }
                1 -> {
                    tab.text = "second"
                }
                2 -> {
                    tab.text = "third"
                }
            }
                fragmentTransition.replace(R.id.view_pager_2,adapter.createFragment(position))

        }.attach()

        fragmentTransition.commit()
    }
}