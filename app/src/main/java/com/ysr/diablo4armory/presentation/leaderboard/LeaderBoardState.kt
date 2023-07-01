package com.ysr.diablo4armory.presentation.leaderboard

import com.ysr.diablo4armory.domain.model.LeaderboardEntry

data class LeaderBoardState (
    val isLoading : Boolean = false,
    val leaderBoardList : List<LeaderboardEntry> = emptyList(),
    val error: String = ""
)