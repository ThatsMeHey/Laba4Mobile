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

class CategoriesAdapter(private val items: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.categoryImage)
        val title: TextView = view.findViewById(R.id.categoryTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Glide.with(holder.itemView.context)
            .load(item.categoryImage)
            .override(600, 600)
            .into(holder.image)
        holder.title.setText(item.categoryTitle)

        holder.itemView.setOnClickListener {
            val destId = when (item.categoryId) {
                0 -> R.id.nav_category1
                1 -> R.id.nav_category2
                2 -> R.id.nav_category3
                3 -> R.id.nav_category4
                else -> return@setOnClickListener
            }
            val navController = holder.itemView.findNavController()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.nav_categories, inclusive = false, saveState = true)
                .setLaunchSingleTop(true)
                .setRestoreState(true)
                .build()
            navController.navigate(destId, null, navOptions)
            if (navController.currentDestination?.id == R.id.detailedPlaceFragment) {
                navController.popBackStack()
            }
        }
    }

    override fun getItemCount() = items.size
}