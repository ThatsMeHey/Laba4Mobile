package com.example.laba4new

class Category2 : Category()
{
    override fun createCategory(): List<CategoryData> {
        val artworks = listOf(
            CategoryData(R.drawable.restaurant1, R.string.restaurant1_title, R.string.restaurant1_desc),
            CategoryData(R.drawable.restaurant2, R.string.restaurant2_title, R.string.restaurant2_desc),
            CategoryData(R.drawable.restaurant3, R.string.restaurant3_title, R.string.restaurant3_desc)
        )
        return artworks;
    }
}
