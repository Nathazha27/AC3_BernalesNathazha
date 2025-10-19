package com.example.ac3_android_nathazha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ac3_android_nathazha.models.Player
import com.example.ac3_android_nathazha.screens.CrashGameScreen
import com.example.ac3_android_nathazha.screens.MainMenuScreen
import com.example.ac3_android_nathazha.screens.Screen
import com.example.ac3_android_nathazha.screens.TresEnRayaScreen
import com.example.ac3_android_nathazha.ui.theme.AC3_Android_NathazhaTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AC3_Android_NathazhaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyGameApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyGameApp(modifier: Modifier = Modifier) {

    var actualScreen = remember { mutableStateOf<Screen>(MainMenuScreen())}

    var actualPlayer by remember { mutableStateOf(Player(score = 0)) }

    var startGame by remember {mutableStateOf(false)}

    var secondsTime by remember { mutableStateOf(0) }

    val minutes = secondsTime / 60
    val seconds = secondsTime % 60
    val timerValue  = "%02d:%02d".format(minutes, seconds)

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            when (startGame) {
                true -> secondsTime++
                false -> secondsTime = 0
            }
        }
    }

    when (val screen = actualScreen.value){
        is MainMenuScreen -> screen.Render(
            {actualScreen.value = TresEnRayaScreen()
                        startGame = true},
            actualPlayer
        )
        is TresEnRayaScreen -> screen.Render(
            {actualScreen.value = MainMenuScreen()
                        startGame = false},
            {actualScreen.value = CrashGameScreen()},
            timerValue,
            actualPlayer,
            stringResource(R.string.titlegame1),
            {actualPlayer.score += 10}
        )
        is CrashGameScreen -> screen.Render(
            {actualScreen.value = TresEnRayaScreen()},
            {actualScreen.value = MainMenuScreen()
                        startGame = false},
            timerValue,
            actualPlayer,
            stringResource(R.string.titlegame2),
            {newScore -> actualPlayer.score = newScore}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AC3_Android_NathazhaTheme {
    }
}