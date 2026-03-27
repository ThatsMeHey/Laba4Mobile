package com.example.laba4new

class Category3 : Category()
{
    override fun createCategory(): List<CategoryData> {
        val artworks = listOf(
            CategoryData(R.drawable.mall1, R.string.mall1_title, R.string.mall1_desc),
            CategoryData(R.drawable.mall2, R.string.mall2_title, R.string.mall2_desc),
            CategoryData(R.drawable.mall3, R.string.mall2_title, R.string.mall2_desc)
        )
        return artworks;
    }
}
