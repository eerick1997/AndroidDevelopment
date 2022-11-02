package com.lyft.android.mealtime

enum class Food(
    //The unicode string that will render as the food's emoji in a TextView.
    val emojiString: String
) {
    CHEESE("\uD83E\uDDC0"),
    STEAK("\uD83E\uDD69"),
    BREAD("\uD83C\uDF5E"),
//    LETTUCE("\uD83E\uDD6C"),
//    TOMATO("\uD83C\uDF45"),
//    ONION("\uD83E\uDDC5")
}
