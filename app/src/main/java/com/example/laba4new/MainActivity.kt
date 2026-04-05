package com.example.laba4new

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.forEach
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navView = findViewById<NavigationView>(R.id.navigation_view)

        bottomNav.setupWithNavController(navController)
        navView.setupWithNavController(navController)

        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        if (drawer != null) {
            val toggle = ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
            )
            drawer.addDrawerListener(toggle)
            toggle.syncState()
        }


        bottomNav.setOnItemSelectedListener { item ->
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.nav_categories, inclusive = false, saveState = true)
                .setLaunchSingleTop(true)
                .setRestoreState(true)
                .build()
            navController.navigate(item.itemId, null, navOptions)
            if (navController.currentDestination?.id == R.id.detailedPlaceFragment) {
                navController.popBackStack()
            }
            true
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val drawerNavIds = setOf(R.id.nav_categories, R.id.nav_about, R.id.nav_settings)
            if (destination.id in drawerNavIds) {
                bottomNav.post {
                    bottomNav.menu.forEach { item -> item.isChecked = false }
                }
            }
        }
    }
}