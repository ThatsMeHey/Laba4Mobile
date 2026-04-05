package com.example.laba4new

data class Category(
    val categoryImage: Int,
    val categoryTitle: Int,
    val categoryId: Int,
    val places: List<Place>,
    val navigationId: Int
)

val categoriesList = listOf(
    Category(R.drawable.park_icon, R.string.category1_title, 0, places1, R.id.nav_category1),
    Category(R.drawable.restaurant_icon,R.string.category2_title, 1, places2, R.id.nav_category2),
    Category(R.drawable.mall_icon,R.string.category3_title, 2, places3, R.id.nav_category3),
    Category(R.drawable.museum_icon,R.string.category4_title, 3, places4, R.id.nav_category4)
)
