package com.example.laba4new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlacesFragment : Fragment() {

    private lateinit var items: List<Place>
    private var catId: Int = 0

    private val args: PlacesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.places_fragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.placesListId)

        val categoryId = args.categoryId
        items = categoriesList[categoryId].places
        catId = categoryId

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PlacesAdapter(items, categoryId)
        return view
    }

    override fun onResume() {
        super.onResume()

        if (catId >= 0 && catId <= 2) {
            val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)
            bottomNav?.menu?.getItem(catId+1)?.isChecked = true
        }
    }
}