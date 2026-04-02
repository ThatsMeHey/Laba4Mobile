package com.example.laba4new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView

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
            val action = CategoriesFragmentDirections
                .actionCategoriesFragmentToPlacesFragment(
                    categoryId = item.categoryId
                )
            holder.itemView.findNavController().navigate(action)

            val bottomNav = (holder.itemView.context as? AppCompatActivity)
                ?.findViewById<BottomNavigationView>(R.id.bottom_nav)

            bottomNav?.menu?.findItem(
                when(item.categoryId) {
                    0 -> R.id.nav_category1
                    1 -> R.id.nav_category2
                    2 -> R.id.nav_category3
                    else -> R.id.nav_main
                }
            )?.isChecked = true

            if (item.categoryId > 2){
                bottomNav?.menu?.let { menu ->
                    for (i in 0 until menu.size()) {
                        menu.getItem(i).isChecked = false
                    }
                }
            }
        }
    }

    override fun getItemCount() = items.size
}