package com.ysr.diablo4armory.data.remote.dto

import com.ysr.diablo4armory.domain.model.EquipmentEntry
import com.ysr.diablo4armory.domain.model.HeroEntry
import com.ysr.diablo4armory.domain.model.SkillEntry

data class HeroDTO(
    val accountLastUpdate: Int,
    val altars: Any,
    val character: String,
    val clan: String,
    val `class`: String,
    val completed_quests: Any,
    val createdAt: Long,
    val dead: Boolean,
    val elitesKilled: Int,
    val equipment: List<Equipment>,
    val fog_of_wars: Any,
    val goldCollected: Int,
    val hardcore: Boolean,
    val lastLogin: Long,
    val lastUpdate: Int,
    val level: Int,
    val monstersKilled: Int,
    val power: Int,
    val queue: Int,
    val secondsPlayed: Int,
    val skillTree: Any,
    val skills: List<Skill>,
    val waypoints: Any,
    val worldTier: Int
)

fun HeroDTO.toEntry() : HeroEntry {

    val equipmentEntryList = ArrayList<EquipmentEntry>()
    equipment.forEach{
        equipmentEntryList.add(it.toEntry())
    }

    val skillList = ArrayList<SkillEntry>()
    skills.forEach{
        skillList.add(it.ToEntry())
    }
    return HeroEntry(
        accountLastUpdate = accountLastUpdate,
        altars = altars,
        character = character,
        clan = clan,
        playerClass = `class`,
        completed_quests = completed_quests,
        createdAt = createdAt,
        dead = dead,
        elitesKilled = elitesKilled,
        equipment = equipmentEntryList.toList(),
        fog_of_wars = fog_of_wars,
        goldCollected = goldCollected,
        hardcore = hardcore,
        lastLogin = lastLogin,
        lastUpdate = lastUpdate,
        level = level,
        monstersKilled = monstersKilled,
        power = power,
        queue = queue,
        secondsPlayed = secondsPlayed,
        skillTree = skillTree,
        skills = skillList,
        waypoints = waypoints,
        worldTier = worldTier
    )
}