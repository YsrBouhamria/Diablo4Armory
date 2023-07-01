package com.ysr.diablo4armory.domain.model

data class EquipmentEntry (
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
