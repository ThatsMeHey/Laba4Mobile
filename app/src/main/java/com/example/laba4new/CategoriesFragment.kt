package com.example.laba4new

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class CategoriesFragment : Fragment() {

    private val items = categoriesList

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.categories_fragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.categoriesListId)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = CategoriesAdapter(items)

        return view
    }

    override fun onResume() {
        super.onResume()

        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav?.menu?.getItem(0)?.isChecked = true
    }
}