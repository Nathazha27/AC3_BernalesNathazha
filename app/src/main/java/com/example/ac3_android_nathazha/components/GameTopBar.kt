package com.example.ac3_android_nathazha.components

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class GameTopBar {
    @Composable
    public fun RenderTopBar(BackScreen: () -> Unit, NextScreen: () -> Unit, timer: String, score: Int){
        Box(
            modifier = Modifier.background(Color(0xFF363C47)).padding(10.dp).padding(WindowInsets.statusBars
                .asPaddingValues())
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = BackScreen
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = NextScreen
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = timer,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    color = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Score: $score",
                    modifier = Modifier.padding(15.dp),
                    textAlign = TextAlign.Right,
                    fontSize = 23.sp,
                    color = Color.White
                )
            }
        }
    }
}