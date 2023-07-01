package com.ysr.diablo4armory.presentation.leaderboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ysr.diablo4armory.common.DrawableMapper
import com.ysr.diablo4armory.domain.model.LeaderboardEntry
import com.ysr.diablo4armory.presentation.components.SkillListComposable

@Composable
fun LeaderBoardItem(
    entry: LeaderboardEntry,
    onItemClick: (LeaderboardEntry) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(10.dp)
            .clickable {
                onItemClick(entry)
            },
        shape = RoundedCornerShape(4.dp),
        elevation = 5.dp,

    ) {
        Box(modifier = Modifier.padding(15.dp)) {
            val drawableId = DrawableMapper.getClassDrawableFromName(entry.playerClass)
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = entry.playerClass,
                contentScale = ContentScale.Crop,
                modifier = Modifier.
                    align(Alignment.CenterStart)
                    .height(70.dp)
                    .width(70.dp)
            )
            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "${entry.name}",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "${entry.playerClass} (lvl ${entry.level}) Power ${entry.power} ",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )


                SkillListComposable(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    skillList = entry.skills
                )
            }
            Text (
                text = if(entry.hardcore) "HC" else "SC",
                color =if(entry.hardcore) Color.Red else Color.Green,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}