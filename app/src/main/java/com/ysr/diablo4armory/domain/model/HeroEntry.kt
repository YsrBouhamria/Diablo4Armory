package com.ysr.diablo4armory.domain.model

import com.ysr.diablo4armory.data.remote.dto.Equipment
import com.ysr.diablo4armory.data.remote.dto.Skill

data class HeroEntry (
    val accountLastUpdate: Int?,
    val altars: Any?,
    val character: String?,
    val clan: String?,
    val `class`: String?,
    val completed_quests: Any?,
    val createdAt: Long?,
    val dead: Boolean?,
    val elitesKilled: Int?,
    val equipment: List<EquipmentEntry>?,
    val fog_of_wars: Any?,
    val goldCollected: Int?,
    val hardcore: Boolean?,
    val lastLogin: Long?,
    val lastUpdate: Int?,
    val level: Int?,
    val monstersKilled: Int?,
    val power: Int?,
    val queue: Int?,
    val secondsPlayed: Int?,
    val skillTree: Any?,
    val skills: List<SkillEntry>?,
    val waypoints: Any?,
    val worldTier: Int?
)