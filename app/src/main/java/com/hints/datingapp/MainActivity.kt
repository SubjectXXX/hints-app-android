package com.hints.datingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hints.datingapp.util.ThemeManager
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    
    private lateinit var themeManager: ThemeManager
    private lateinit var bottomNav: BottomNavigationView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize theme manager
        themeManager = ThemeManager(this)
        
        // Observe theme changes
        lifecycleScope.launch {
            themeManager.isNightMode.collect { isNightMode ->
                AppCompatDelegate.setDefaultNightMode(
                    if (isNightMode) AppCompatDelegate.MODE_NIGHT_YES
                    else AppCompatDelegate.MODE_NIGHT_NO
                )
            }
        }
        
        setContentView(R.layout.activity_main)
        
        bottomNav = findViewById(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    showProfileFragment()
                    true
                }
                R.id.nav_discover -> {
                    showDiscoverFragment()
                    true
                }
                R.id.nav_wall -> {
                    showWallFragment()
                    true
                }
                R.id.nav_likes -> {
                    showLikesFragment()
                    true
                }
                R.id.nav_settings -> {
                    showSettingsFragment()
                    true
                }
                else -> false
            }
        }
        
        // Show discover fragment by default
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_discover
        }
    }
    
    private fun showProfileFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ProfileFragment())
            .commit()
    }
    
    private fun showDiscoverFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DiscoverFragment())
            .commit()
    }
    
    private fun showWallFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, WallFragment())
            .commit()
    }
    
    private fun showLikesFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LikesFragment())
            .commit()
    }
    
    private fun showSettingsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SettingsFragment())
            .commit()
    }
}
