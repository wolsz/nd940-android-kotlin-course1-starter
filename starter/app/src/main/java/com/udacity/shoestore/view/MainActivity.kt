package com.udacity.shoestore.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.shoeNavHostFragment) as NavHostFragment
        Log.i("MainActivity", navHostFragment.toString() )
        navController = navHostFragment.navController
        Log.i("MainActivity", navController.toString() )
//        val navController = this.findNavController(R.id.shoeNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.shoeNavHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
        return navController.navigateUp()
    }
}
