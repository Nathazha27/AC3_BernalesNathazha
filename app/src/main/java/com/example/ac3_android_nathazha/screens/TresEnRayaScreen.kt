package com.example.ac3_android_nathazha.screens

import androidx.compose.runtime.Composable
import com.example.ac3_android_nathazha.components.GameTopBar
import com.example.ac3_android_nathazha.models.Player

class TresEnRayaScreen: Screen() {
    val topBar = GameTopBar()
    @Composable
    fun Render(BackScreen: () -> Unit, NextScreen: () -> Unit, timer: String, player: Player){
        topBar.RenderTopBar(BackScreen, NextScreen, timer, player.score)
    }
}