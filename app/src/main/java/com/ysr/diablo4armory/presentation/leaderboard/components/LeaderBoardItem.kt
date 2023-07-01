package com.ysr.diablo4armory.presentation.leaderboard.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ysr.diablo4armory.domain.model.LeaderboardEntry

@Composable
fun LeaderBoardItem(
    entry: LeaderboardEntry,
    onItemClick: (LeaderboardEntry) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(entry) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${entry.name} ${entry.`class`} ${entry.level}",
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Ellipsis
        )
        Text (
            text = if(entry.hardcore) "HC" else "SC",
            color =if(entry.hardcore) Color.Red else Color.Green,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}