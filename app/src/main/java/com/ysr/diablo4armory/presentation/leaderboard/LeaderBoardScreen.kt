package com.ysr.diablo4armory.presentation.leaderboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ysr.diablo4armory.presentation.Screen
import com.ysr.diablo4armory.presentation.leaderboard.components.LeaderBoardItem

@Composable
fun LeaderBoardScreen(
    navController: NavController,
    viewModel: LeaderBoardViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = "Diablo 4 Leaderboard",
            style = MaterialTheme.typography.h1,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .align(CenterHorizontally)
        )
        LazyColumn(modifier = Modifier.fillMaxSize().align(CenterHorizontally)) {
            items(state.leaderBoardList) { leaderBoardItem ->
                LeaderBoardItem(
                    entry = leaderBoardItem,
                    onItemClick =  {
                        navController.navigate(Screen.HeroDetailsScreen.route + "/${leaderBoardItem.battleTag}" + "/${leaderBoardItem.heroId}")
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(CenterHorizontally)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.align(CenterHorizontally)
            )
        }
    }
}