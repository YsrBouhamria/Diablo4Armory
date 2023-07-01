package com.ysr.diablo4armory.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


@Composable
fun SkillComposable(
    modifier: Modifier = Modifier,
    spellName: String?,
    painter: Painter
) {
        Box(modifier = modifier.width(35.dp).height(35.dp)) {
            Image(
                painter = painter,
                contentDescription = spellName,
                contentScale = ContentScale.Crop
            )
        }
}