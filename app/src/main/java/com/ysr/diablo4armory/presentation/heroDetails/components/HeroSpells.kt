package com.ysr.diablo4armory.presentation.heroDetails.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.text.style.TextAlign
import com.ysr.diablo4armory.domain.model.SkillEntry

@Composable
fun HeroSkills(
    skills: List<SkillEntry>?
) {
    Box(modifier = Modifier.padding(10.dp)) {
        LazyRow(modifier = Modifier.fillMaxSize()) {
            skills?.let {
                items(skills) { skillItem ->
                    Text(
                        text = "${skillItem.name} ",
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
