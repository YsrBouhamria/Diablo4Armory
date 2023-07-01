package com.ysr.diablo4armory.domain.model

data class LeaderboardEntry (
    val battleTag: String,
    val `class`: String,
    val dead: Boolean,
    val hardcore: Boolean,
    val heroId: String,
    val lastUpdate: Int,
    val level: Int,
    val name: String,
    val power: Int,
    val skills: List<String>
)