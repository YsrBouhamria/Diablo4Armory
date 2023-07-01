package com.ysr.diablo4armory.presentation.heroDetails

import com.ysr.diablo4armory.domain.model.HeroEntry
import com.ysr.diablo4armory.domain.model.LeaderboardEntry

data class HeroDetailsState (
    val isLoading : Boolean = false,
    val hero : HeroEntry? = null,
    val error: String = ""
)