package com.example.laba4new

import android.content.Context

data class CategoriesWithNames(
    val categoryNameRes: Int,
    val categoryItems: List<CategoryData>
){
    companion object {
        fun createList(cat : Category): List<CategoryData> {
            return cat.createCategory();
        }
    }
}

val categoriesWithNames = listOf(
    CategoriesWithNames(R.string.category1_title, CategoriesWithNames.createList(Category1())),
    CategoriesWithNames(R.string.category2_title, CategoriesWithNames.createList(Category2())),
    CategoriesWithNames(R.string.category3_title, CategoriesWithNames.createList(Category3()))
)