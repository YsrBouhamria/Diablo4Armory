package com.ysr.diablo4armory.data.remote

import com.ysr.diablo4armory.data.remote.dto.HeroDTO
import com.ysr.diablo4armory.data.remote.dto.LeaderboardDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface D4ArmoryAPI {


    @GET("/api/leaderboard")
    suspend fun getLeaderBoardByParams(
        @Query("class") `class`: String?,
        @Query("mode") mode : String?,
        @Query("rank") rank : String?,
        @Query("pageSize") pageSize : String?,
        @Query("pageNumber") pageNumber : String?
    ) : List<LeaderboardDTO>

    @GET("/api/armory/{accountId}/{heroId}")
    suspend fun getHero(@Path("accountId") accountId: String, @Path("heroId") heroId: String) : HeroDTO
}