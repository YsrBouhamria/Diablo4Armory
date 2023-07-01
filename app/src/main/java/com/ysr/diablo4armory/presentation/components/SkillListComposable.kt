package com.ysr.diablo4armory.presentation.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ysr.diablo4armory.common.DrawableMapper

@Composable
fun SkillListComposable(
    modifier: Modifier = Modifier,
    skillList: List<String>
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        skillList.forEach { skill ->
            val drawableId = DrawableMapper.getSpellDrawableFromName(skill)
            SkillComposable(
                modifier = Modifier.padding(5.dp),
                spellName = skill,
                painter = painterResource(id = drawableId)
            )
        }
    }

}