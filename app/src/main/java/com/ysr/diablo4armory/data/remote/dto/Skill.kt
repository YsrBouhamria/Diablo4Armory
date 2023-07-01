package com.ysr.diablo4armory.data.remote.dto

import com.ysr.diablo4armory.domain.model.SkillEntry

data class Skill(
    val desc: String,
    val name: String
)

fun Skill.ToEntry() : SkillEntry {
    return SkillEntry(
        desc,
        name
    )
}