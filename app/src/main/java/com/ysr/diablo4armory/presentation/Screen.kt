package com.ysr.diablo4armory.presentation

sealed class Screen (val route: String) {
    object LeaderBoardScreen : Screen("leaderboardList")
    object HeroDetailsScreen : Screen("heroDetailsScreen")
}