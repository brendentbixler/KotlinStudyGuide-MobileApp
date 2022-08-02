package com.example.kotlinstudyguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlinstudyguide.databinding.ActivityMainBinding
import com.example.kotlinstudyguide.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val kotlinFragment = KotlinFragment()
    private val androidFragment = AndroidFragment()
    private val thirdPartyFragment = ThirdPartyFragment()
    private val homeFragment = HomeFragment()
    private val newFragment = NewFragment()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set default icon
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.ic_home

        // set initial fragment
        replaceFragment(homeFragment)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_kotlin -> replaceFragment(kotlinFragment)
                R.id.ic_android -> replaceFragment(androidFragment)
                R.id.ic_third_party -> replaceFragment(thirdPartyFragment)
                R.id.ic_news -> replaceFragment(newFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment, fragment.tag)
        transaction.commit()

    }
}