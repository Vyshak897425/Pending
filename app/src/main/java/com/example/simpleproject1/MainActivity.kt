package com.example.simpleproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import androidx.viewpager2.widget.ViewPager2
import com.example.simpleproject1.adapters.ViewPagerAdapter
import com.example.simpleproject1.databinding.ActivityMainBinding
import com.example.simpleproject1.fragments.SecondFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentArray = arrayOf(
            "First","Second","Third"
        )
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView( binding.root)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

//        val secondFragment = SecondFragment()
//        val fragmentManager : FragmentManager = supportFragmentManager
//        val fragmentTransition : FragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransition.replace(R.id.view_pager_2,secondFragment).commit()



        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager2) { tab, position ->
            tab.text = fragmentArray[position]
        }.attach()
    }
}