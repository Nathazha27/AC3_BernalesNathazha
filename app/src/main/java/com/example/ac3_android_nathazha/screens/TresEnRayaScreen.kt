package com.example.ac3_android_nathazha.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ac3_android_nathazha.R
import com.example.ac3_android_nathazha.components.GameTopBar
import com.example.ac3_android_nathazha.models.Player

class TresEnRayaScreen: Screen() {
    val topBar = GameTopBar()
    @Composable
    fun Render(BackScreen: () -> Unit, NextScreen: () -> Unit, timer: String, player: Player, title: String, win: () -> Unit){
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
            GameLogic(win)
        }
    }
    @Composable
    fun GameLogic(win: () -> Unit){
        var tablero by remember {mutableStateOf(List(9){""})}

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ){
            for (i in 0 until 3) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    for (j in 0 until 3){
                        val tableroIndex = i * 3 + j
                        Button(
                            onClick = { PlayButton(tableroIndex, tablero,{tablero = it}, win)},
                            enabled = tablero[tableroIndex].isEmpty(),
                            modifier = Modifier.padding(5.dp).size(100.dp)
                        ){
                            Text(
                                text = tablero[tableroIndex],
                                fontSize = 30.sp
                            )
                        }
                    }
                }
            }
        }
    }

    fun PlayButton(indexTablero: Int, tablero: List<String>, newTablero: (List<String>) -> Unit, win: () -> Unit){
        if (tablero[indexTablero].isNotEmpty())
            return

        val tableroTmp = tablero.toMutableList()
        tableroTmp[indexTablero] = "O"

        val casillasEmpty = tableroTmp.withIndex().filter{it.value.isEmpty()}.map{it.index}
        if (casillasEmpty.isNotEmpty()){
            val enemyIndex = casillasEmpty.random()
            tableroTmp[enemyIndex] = "X"
        }

        newTablero(tableroTmp)

        val probWin = listOf(
            listOf(0,4,8),
            listOf(2,4,6),
            listOf(0,1,2),
            listOf(3,4,5),
            listOf(6,7,8),
            listOf(0,3,6),
            listOf(1,4,7),
            listOf(2,5,8),
        )

        if (CheckWin(tableroTmp, probWin)){
            win()
            for(i in tableroTmp.indices) {
                tableroTmp[i] = ""
            }
            newTablero(tableroTmp)
        }

        if (CheckGameOver(tableroTmp, probWin)){
            for(i in tableroTmp.indices) {
                tableroTmp[i] = ""
            }
            newTablero(tableroTmp)
        }
    }

    fun CheckWin (tablero: List<String>, probWin: List<List<Int>>): Boolean {
        val player = "O"

        for (i in probWin.indices){
            if (tablero[probWin[i][0]] == player && tablero[probWin[i][1]] == player && tablero[probWin[i][2]] == player){
                return true
            }
        }
        return false
    }

    fun CheckGameOver (tablero: List<String>, probWin: List<List<Int>>): Boolean {
        val enemy = "X"

        for (i in probWin.indices){
            if (tablero[probWin[i][0]] == enemy && tablero[probWin[i][1]] == enemy && tablero[probWin[i][2]] == enemy){
                return true
            }
        }
        return false
    }
}