package com.example.laba4new

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey

class PlacesAdapter(private val categoryId: Int) :
    RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {
    private val items = categoriesList[categoryId].places

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.placeImage)
        val title: TextView = view.findViewById(R.id.placeTitle)
        val description: TextView = view.findViewById(R.id.placeDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.place_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Glide.with(holder.itemView.context)
            .load(item.imageRes)
            .override(800, 600)
            .signature(ObjectKey(item.imageRes))
            .into(holder.image)
        holder.title.setText(item.titleRes)
        holder.description.setText(item.descriptionRes)

        holder.itemView.setOnClickListener {
            val action = NavGraphDirections.actionGlobalDetailedPlaceFragment(
                categoryId = categoryId,
                placeId = item.placeId
            )
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = items.size
}