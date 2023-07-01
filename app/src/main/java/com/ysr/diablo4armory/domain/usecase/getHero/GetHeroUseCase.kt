package com.ysr.diablo4armory.domain.usecase.getHero

import com.ysr.diablo4armory.common.Resource
import com.ysr.diablo4armory.data.remote.dto.toEntry
import com.ysr.diablo4armory.domain.repository.LeaderBoardRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(private val repository : LeaderBoardRepository ) {

    operator fun invoke(accountId: String, heroId: String) = flow  {
        try {
            emit(Resource.Loading())
            val heroEntries = repository.getHero(
                accountId,
                heroId
            )
            emit(Resource.Success(heroEntries.toEntry()))
        }
     catch (e: HttpException) {
        emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
     }
     catch (e: IOException) {
        emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection"))
     }
    }
}