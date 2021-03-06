package com.sejo.uberclone.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBar.DISPLAY_SHOW_TITLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.sejo.uberclone.R
import com.sejo.uberclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayOptions(0, DISPLAY_SHOW_TITLE)
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.welcome_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.welcome_nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}