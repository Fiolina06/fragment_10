package com.example.fragment_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_10.fragment.HomeFragment
import com.example.fragment_10.fragment.NotificationFragment
import com.example.fragment_10.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NotificationFragment = NotificationFragment()
        val SettingsFragment = SettingsFragment()
        val HomeFragment = HomeFragment()

        makeCurrentFragment(HomeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.botton_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener{

            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(HomeFragment)
                R.id.menu_notification -> makeCurrentFragment(NotificationFragment)
                R.id.menu_settings -> makeCurrentFragment(SettingsFragment)
            }
            true
        }
    }


    private fun makeCurrentFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}