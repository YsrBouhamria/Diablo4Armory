package com.ysr.diablo4armory.domain.usecase.getleaderboard

import androidx.compose.runtime.toMutableStateList
import com.ysr.diablo4armory.common.Resource
import com.ysr.diablo4armory.data.remote.dto.toEntry
import com.ysr.diablo4armory.domain.model.LeaderboardEntry
import com.ysr.diablo4armory.domain.repository.LeaderBoardRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLeaderBoardUseCase @Inject constructor(private val repository: LeaderBoardRepository) {

    operator fun invoke(
        classx :String?,
        mode: String?,
        rank: String?,
        pageSize: Int?,
        pageNumber: Int?
    ) = flow {
        try {
            emit(Resource.Loading())
            val leaderBoardEntries = repository.getLeaderBoardByParam(
                classx,
                mode,
                rank,
                pageSize,
                pageNumber
            )
            emit(Resource.Success(leaderBoardEntries.map {
                it.toEntry()
            }.toMutableStateList()))
        }
        catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
        }
    }
}