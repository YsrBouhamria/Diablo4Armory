package com.ysr.diablo4armory.presentation.heroDetails.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ysr.diablo4armory.domain.model.EquipmentEntry

@Composable
fun HeroEquipmentList(
    equipmentList : List<EquipmentEntry>?
) {
    Box(modifier = Modifier.padding(10.dp)) {
        LazyRow(modifier = Modifier.fillMaxSize()) {
            equipmentList?.let {
                items(equipmentList) { equipmentItem ->
                    Text(
                        text = "${equipmentItem.name} ",
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}