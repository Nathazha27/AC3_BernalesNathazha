package com.example.ac3_android_nathazha.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ac3_android_nathazha.components.GameTopBar
import com.example.ac3_android_nathazha.models.Player

class CrashGameScreen: Screen() {
    val topBar = GameTopBar()
    @Composable
    fun Render(BackScreen: () -> Unit, NextScreen: () -> Unit, timer: String, player: Player, title: String){
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
            GameLogic()
        }
    }
    @Composable
    fun GameLogic(){

    }
}