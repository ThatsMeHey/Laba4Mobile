package com.example.laba4new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlacesFragment : Fragment() {
    private val args: PlacesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.places_fragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.placesListId)

        val categoryId = args.categoryId

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PlacesAdapter(categoryId)
        return view
    }
}