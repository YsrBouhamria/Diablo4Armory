package com.ysr.diablo4armory.domain.repository

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ysr.diablo4armory.data.remote.dto.HeroDTO
import com.ysr.diablo4armory.data.remote.dto.LeaderboardDTO

interface LeaderBoardRepository {

    suspend fun getLeaderBoardByParam(
        `class`: String?,
        mode: String?,
        rank: String?,
        pageSize: Int?,
        pageNumber: Int?
    ) : SnapshotStateList<LeaderboardDTO>
    suspend fun getHero(
        accountId : String,
        heroId: String
    ) : HeroDTO
}