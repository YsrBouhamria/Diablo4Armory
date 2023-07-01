package com.ysr.diablo4armory.domain.repository

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ysr.diablo4armory.data.remote.D4ArmoryAPI
import com.ysr.diablo4armory.data.remote.dto.HeroDTO
import com.ysr.diablo4armory.data.remote.dto.LeaderboardDTO
import javax.inject.Inject

class LeaderBoardRepositoryImpl @Inject constructor(private val api: D4ArmoryAPI) : LeaderBoardRepository {

    override suspend fun getLeaderBoardByParam(
        `class`: String?,
        mode: String?,
        rank: String?,
        pageSize: Int?,
        pageNumber: Int?
    ): SnapshotStateList<LeaderboardDTO> {
       return api.getLeaderBoardByParams(
           `class`,
           mode,
           rank,
           pageSize,
           pageNumber
       )
    }

    override suspend fun getHero(accountId: String, heroId: String): HeroDTO {
        return api.getHero(
            accountId,
            heroId
        )
    }
}