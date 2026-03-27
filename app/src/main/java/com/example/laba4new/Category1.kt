package com.example.laba4new

class Category1 : Category()
{
    override fun createCategory(): List<CategoryData> {
        val artworks = listOf(
            CategoryData(R.drawable.park1, R.string.park1_title, R.string.park1_desc),
            CategoryData(R.drawable.park2, R.string.park2_title, R.string.park2_desc),
            CategoryData(R.drawable.park3, R.string.park3_title, R.string.park3_desc)
        )
        return artworks;
    }
}
