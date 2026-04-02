package com.example.laba4new

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = findNavController(R.id.nav_host_fragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.setupWithNavController(navController)



        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navView = findViewById<NavigationView>(R.id.navigation_view)

        toolbar.title = getString(R.string.app_name)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId)
            {
                R.id.nav_categories -> {
                    navController.navigate(R.id.categoriesFragment)
                }
                R.id.nav_about -> {
                    val action = PlacesFragmentDirections
                        .actionGlobalAboutFragment()
                    navController.navigate(action)
                }
                R.id.nav_settings -> {
                    val action = PlacesFragmentDirections
                        .actionGlobalSettingsFragment()
                    navController.navigate(action)
                }
            }
            drawer.closeDrawers()
            true
        }

        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_main -> {
                    navController.navigate(R.id.categoriesFragment)
                    true
                }
                R.id.nav_category1 -> {
                    val action = PlacesFragmentDirections
                        .actionGlobalPlacesFragment(
                            categoryId = 0
                        )
                    navController.navigate(action)
                    true
                }
                R.id.nav_category2 -> {
                    val action = PlacesFragmentDirections
                        .actionGlobalPlacesFragment(
                            categoryId = 1
                        )
                    navController.navigate(action)
                    true
                }
                R.id.nav_category3 -> {
                    val action = PlacesFragmentDirections
                        .actionGlobalPlacesFragment(
                            categoryId = 2
                        )
                    navController.navigate(action)
                    true
                }
                else -> false
            }
        }
    }
}