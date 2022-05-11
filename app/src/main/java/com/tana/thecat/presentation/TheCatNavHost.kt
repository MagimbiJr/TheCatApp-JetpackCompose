package com.tana.thecat.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.thecat.presentation.cat_details.CatDetailsScreen
import com.tana.thecat.presentation.cats_list.CatDetails
import com.tana.thecat.presentation.cats_list.CatListScreen
import com.tana.thecat.utils.TheCatScreens

@Composable
fun TheCatNavHost(
    navHostController: NavHostController,
    systemUiController: SystemUiController
) {
    NavHost(
        navController = navHostController,
        startDestination = TheCatScreens.CatListScreen.route,
    ) {
        composable(TheCatScreens.CatListScreen.route) {
            CatListScreen(
                systemUiController = systemUiController,
                navHostController = navHostController
            )
        }
        composable(
            "${TheCatScreens.CatDetailsScreen.route}/{breed_id}",
//            arguments = listOf(
//                navArgument(name = "breed_id") { type = NavType.StringType}
//            )
        ) {// navBackStackEntry ->
            //val breedId = navBackStackEntry.arguments?.getString("breed_id")!!
            CatDetailsScreen()
        }
    }
}