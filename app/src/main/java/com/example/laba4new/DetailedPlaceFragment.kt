package com.example.laba4new

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import kotlin.getValue

class DetailedPlaceFragment : Fragment() {

    private val args: DetailedPlaceFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detailed_place_fragment, container, false)

        val categoryId = args.categoryId
        val placeId = args.placeId
        var items = categoriesList[categoryId].places
        var item = items[placeId]


        val title = view.findViewById<TextView>(R.id.detailTitle)
        val description = view.findViewById<TextView>(R.id.detailDescription)
        val image = view.findViewById<ImageView>(R.id.detailImage)

        title.setText(item.titleRes)
        description.setText(item.descriptionRes)
        Glide.with(this)
            .load(item.imageRes)
            .signature(ObjectKey(item.imageRes))
            .into(image)

        return view
    }
}