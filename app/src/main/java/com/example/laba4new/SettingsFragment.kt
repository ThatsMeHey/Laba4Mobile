package com.example.laba4new

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class SettingsFragment : Fragment() {

    private lateinit var prefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.settings_fragment, container, false)

        prefs = requireActivity().getSharedPreferences("settings", Context.MODE_PRIVATE)

        val btnRussian = view.findViewById<Button>(R.id.btnRussian)
        val btnEnglish = view.findViewById<Button>(R.id.btnEnglish)

        btnRussian.setOnClickListener {
            setLocale("ru")
        }

        btnEnglish.setOnClickListener {
            setLocale("en")
        }

        return view
    }

    override fun onResume() {
        super.onResume()

        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav?.menu?.let { menu ->
            for (i in 0 until menu.size()) {
                menu.getItem(i).isChecked = false
            }
        }
    }

    private fun setLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        requireActivity().baseContext.resources.updateConfiguration(config, resources.displayMetrics)
        prefs.edit().putString("lang", language).apply()
        requireActivity().recreate()
    }
}