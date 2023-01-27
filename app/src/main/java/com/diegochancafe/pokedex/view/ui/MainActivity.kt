package com.diegochancafe.pokedex.view.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.diegochancafe.pokedex.R
import com.diegochancafe.pokedex.databinding.ActivityMainBinding
import com.google.android.gms.security.ProviderInstaller
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // --
    private lateinit var binding: ActivityMainBinding

    // --
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // --
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // --
        updateAndroidSecurityProvider()
        // --
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home
            )
        )
        // --
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        // --
        supportActionBar?.hide()
    }

    // --
    private fun updateAndroidSecurityProvider() {
        // --
        try {
            ProviderInstaller.installIfNeeded(this)
        } catch (e: Exception) {
            e.message
        }
    }
}