package com.ysr.diablo4armory.data.remote.dto

import com.ysr.diablo4armory.domain.model.LeaderboardEntry

data class LeaderboardDTO(
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

fun LeaderboardDTO.toEntry() : LeaderboardEntry {
    return LeaderboardEntry(
        battleTag = battleTag,
        `class` = `class`,
        dead = dead,
        hardcore = hardcore,
        heroId = heroId,
        lastUpdate = lastUpdate,
        level = level,
        name = name,
        power = power,
        skills = skills
    )
}