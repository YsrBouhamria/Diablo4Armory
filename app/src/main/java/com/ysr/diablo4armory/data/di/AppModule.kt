package com.ysr.diablo4armory.data.di

import com.ysr.diablo4armory.common.Constants
import com.ysr.diablo4armory.data.remote.D4ArmoryAPI
import com.ysr.diablo4armory.domain.repository.LeaderBoardRepository
import com.ysr.diablo4armory.domain.repository.LeaderBoardRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesLeaderBoardApi() : D4ArmoryAPI {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(D4ArmoryAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesLeaderBoardRepository(api : D4ArmoryAPI) : LeaderBoardRepository {
        return LeaderBoardRepositoryImpl(api)
    }

}