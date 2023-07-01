package com.ysr.diablo4armory.data.remote.dto

import com.ysr.diablo4armory.domain.model.EquipmentEntry

data class Equipment(
    val added_affixes: List<String>,
    val base_affixes: List<String>,
    val itemtype: String,
    val name: String,
    val power: Int,
    val quality_level: String,
    val quality_modifier: Int,
    val required_level: Int,
    val strikethrough_affixes: List<String>,
    val tex: Long,
    val upgrades: Int
)

fun Equipment.toEntry() : EquipmentEntry {
    return EquipmentEntry(
        added_affixes,
        base_affixes,
        itemtype,
        name,
        power,
        quality_level,
        quality_modifier,
        required_level,
        strikethrough_affixes,
        tex,
        upgrades
    )
}

