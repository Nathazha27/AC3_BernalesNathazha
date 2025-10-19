package com.example.ac3_android_nathazha.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ac3_android_nathazha.components.GameTopBar
import com.example.ac3_android_nathazha.models.Player
import kotlin.random.Random

class CrashGameScreen: Screen() {
    val topBar = GameTopBar()
    @Composable
    fun Render(BackScreen: () -> Unit, NextScreen: () -> Unit, timer: String, player: Player, title: String, newScore: (Int) -> Unit){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            topBar.RenderTopBar(BackScreen, NextScreen, timer, player.score)
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                text = title,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(30.dp))
            GameLogic(player, newScore)
        }
    }
    @Composable
    fun GameLogic(player: Player, newScore: (Int) -> Unit){
        var multiplyScore by remember {mutableStateOf(1.0f)}
        var score by remember {mutableStateOf(player.score)}

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "x $multiplyScore",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Text(
                text = "Score: $score",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Row(
                modifier = Modifier.padding(20.dp)
            ){
                Button(
                    onClick = {
                        if (multiplyScore >= 1.0) {
                            val resultado = Random.nextDouble()
                            if (resultado <= 0.7) {
                                multiplyScore += 0.1f
                            } else {
                                multiplyScore = 0.0f
                            }
                            val finalScore = (score * multiplyScore).toInt()
                            score = finalScore
                        }else {
                            multiplyScore = 1.0f
                        }
                    }
                ){
                    Text(
                        text = "Try",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Button(
                    onClick = {
                        multiplyScore = 1.0f
                        newScore(score)
                    }

                ){
                    Text(
                        text = "Finish",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}