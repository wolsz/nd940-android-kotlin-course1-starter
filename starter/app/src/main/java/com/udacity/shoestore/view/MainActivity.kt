package com.udacity.shoestore.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ActivityViewModel
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    private lateinit var viewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        setSupportActionBar(binding.toolbar)

        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.listingFragment, R.id.loginFragment)
            .build()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.shoeNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
//        NavigationUI.setupActionBarWithNavController(this, navController)

        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
//        viewModel.newShoe = Shoe("New Shoe", 29.0, "WolszShoes", "This is a new shoe.")

        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
