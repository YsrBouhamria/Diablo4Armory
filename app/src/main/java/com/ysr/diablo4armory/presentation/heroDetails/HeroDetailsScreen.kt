package com.ysr.diablo4armory.presentation.heroDetails

import android.graphics.Color
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ysr.diablo4armory.presentation.heroDetails.components.HeroEquipmentList
import com.ysr.diablo4armory.presentation.heroDetails.components.HeroSkills

@Composable
fun HeroDetailsScreen(
    viewModel: HeroDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    state.hero?.let { hero ->
        LazyColumn(
            modifier = Modifier
            .fillMaxSize(),
            contentPadding = PaddingValues(20.dp)) {
            item {
                Text(
                        text = " ${hero.character} ${hero.`class`} ${hero.level}",
                        style = MaterialTheme.typography.h3                )

                Text(
                        text = if(hero?.dead == true) "DEAD" else "ALIVE"
                    )

                Spacer(modifier = Modifier.height(14.dp))
                HeroEquipmentList(equipmentList = hero.equipment)
                Spacer(modifier = Modifier.height(14.dp))
                HeroSkills(skills = hero.skills)

            }
        }
    }
}