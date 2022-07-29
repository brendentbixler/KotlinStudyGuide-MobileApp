package com.example.kotlinstudyguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlinstudyguide.databinding.ActivityMainBinding
import com.example.kotlinstudyguide.fragments.AndroidFragment
import com.example.kotlinstudyguide.fragments.HomeFragment
import com.example.kotlinstudyguide.fragments.KotlinFragment
import com.example.kotlinstudyguide.fragments.ThirdPartyFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val kotlinFragment = KotlinFragment()
    private val androidFragment = AndroidFragment()
    private val thirdPartyFragment = ThirdPartyFragment()
    private val homeFragment = HomeFragment()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(homeFragment)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_kotlin -> replaceFragment(kotlinFragment)
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_android -> replaceFragment(androidFragment)
                R.id.ic_third_party -> replaceFragment(thirdPartyFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

    }
}