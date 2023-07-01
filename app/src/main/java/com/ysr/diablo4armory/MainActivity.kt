package com.ysr.diablo4armory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ysr.diablo4armory.presentation.Screen
import com.ysr.diablo4armory.presentation.heroDetails.HeroDetailsScreen
import com.ysr.diablo4armory.presentation.leaderboard.LeaderBoardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              Surface(color = MaterialTheme.colors.background) {
                  val navController = rememberNavController()
                  NavHost(navController = navController, startDestination = Screen.LeaderBoardScreen.route) {
                      composable(route = Screen.LeaderBoardScreen.route) {
                          LeaderBoardScreen(navController)
                      }
                      composable(route = Screen.HeroDetailsScreen.route + "/{accountId}" + "/{heroId}",
                          arguments = listOf(
                              navArgument("accountId") {
                                  type = NavType.StringType
                              },
                              navArgument("heroId") { // Notice over here
                                  type = NavType.StringType
                              }
                          )) {
                          HeroDetailsScreen()
                      }
                  }
              }

        }
    }
}

