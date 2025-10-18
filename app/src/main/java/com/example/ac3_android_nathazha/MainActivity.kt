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
import androidx.compose.ui.tooling.preview.Preview
import com.example.ac3_android_nathazha.models.Player
import com.example.ac3_android_nathazha.models.Screen
import com.example.ac3_android_nathazha.screens.CrashGameScreen
import com.example.ac3_android_nathazha.screens.MainMenuScreen
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
    var playerScore by remember { mutableStateOf(Player(name = "Nathazha", score = 0)) }
    var secondsTime by remember { mutableStateOf(0)}

    val timer = remember(secondsTime){
        val minutes = secondsTime / 60
        val seconds = secondsTime % 60
        "%02d:02d".format(minutes, seconds)
    }

    LaunchedEffect(Unit){
        while(true){
            delay(1000L)
            secondsTime++
        }
    }


}


@Composable
fun ScreenCharger(screen: Screen){
    when(screen) {
        Screen.MainMenu -> MainMenuScreen.ShowMainMenu()
        Screen.TresEnRaya -> TresEnRayaScreen.ShowTresEnRaya()
        Screen.CrashGame -> CrashGameScreen.ShowCrashGame()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AC3_Android_NathazhaTheme {
    }
}