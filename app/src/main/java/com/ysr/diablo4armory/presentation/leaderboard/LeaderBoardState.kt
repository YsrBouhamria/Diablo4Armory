package com.ysr.diablo4armory.presentation.leaderboard

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ysr.diablo4armory.domain.model.LeaderboardEntry

data class LeaderBoardState (
    val isLoading : Boolean = false,
    val leaderBoardList : SnapshotStateList<LeaderboardEntry> = mutableStateListOf(),
    val orderBy: LeaderBoardOrder = LeaderBoardOrder.TIME,
    val filterModeValue : LeaderBoardFilterMode = LeaderBoardFilterMode.ALL,
    val filterClassValue: LeaderBoardFilterClass = LeaderBoardFilterClass.ALL,
    val error: String = ""
)


enum class LeaderBoardFilterClass {
    SORCERER, BARBARIAN, ROGUE, NECROMANCER, DRUID, ALL
}
enum class LeaderBoardFilterMode {
    HARDCORE, SOFTCORE, ALL
}
enum class LeaderBoardOrder {
    TIME, PVP, POWER
}