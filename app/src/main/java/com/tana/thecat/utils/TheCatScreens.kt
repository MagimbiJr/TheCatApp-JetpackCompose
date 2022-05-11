package com.tana.thecat.utils

sealed class TheCatScreens(val route: String) {
    object CatListScreen : TheCatScreens(route = "cat_list_screen")
    object CatDetailsScreen : TheCatScreens(route = "cat_details_screen")
}
