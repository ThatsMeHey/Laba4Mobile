package com.example.laba4new

data class Place(
    val placeId: Int,
    val imageRes: Int,
    val titleRes: Int,
    val descriptionRes: Int
)

val places1 = listOf(
    Place(0,R.drawable.park1, R.string.park1_title, R.string.park1_desc),
    Place(1,R.drawable.park2, R.string.park2_title, R.string.park2_desc),
    Place(2,R.drawable.park3, R.string.park3_title, R.string.park3_desc),
    Place(3,R.drawable.park4, R.string.park4_title, R.string.park4_desc)
)

val places2 = listOf(
    Place(0,R.drawable.restaurant1, R.string.restaurant1_title, R.string.restaurant1_desc),
    Place(1,R.drawable.restaurant2, R.string.restaurant2_title, R.string.restaurant2_desc),
    Place(2,R.drawable.restaurant3, R.string.restaurant3_title, R.string.restaurant3_desc),
    Place(3,R.drawable.restaurant4, R.string.restaurant4_title, R.string.restaurant4_desc),
    Place(4,R.drawable.restaurant5, R.string.restaurant5_title, R.string.restaurant5_desc)
)

val places3 = listOf(
    Place(0,R.drawable.mall1, R.string.mall1_title, R.string.mall1_desc),
    Place(1,R.drawable.mall2, R.string.mall2_title, R.string.mall2_desc),
    Place(2,R.drawable.mall3, R.string.mall3_title, R.string.mall3_desc),
    Place(3,R.drawable.mall4, R.string.mall4_title, R.string.mall4_desc),
    Place(4,R.drawable.mall5, R.string.mall5_title, R.string.mall5_desc)
)

val places4 = listOf(
    Place(0,R.drawable.museum1, R.string.museum1_title, R.string.museum1_desc),
    Place(1,R.drawable.museum2, R.string.museum2_title, R.string.museum2_desc),
    Place(2,R.drawable.museum3, R.string.museum3_title, R.string.museum3_desc),
    Place(3,R.drawable.museum4, R.string.museum4_title, R.string.museum4_desc),
    Place(4,R.drawable.museum5, R.string.museum5_title, R.string.museum5_desc)
)