package com.example.ac3_android_nathazha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ac3_android_nathazha.ui.theme.AC3_Android_NathazhaTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AC3_Android_NathazhaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InicioApp("TITULO", 0)
                }
            }
        }
    }
}

@Composable
fun InicioApp(titulo: String, score: Int,modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(25.dp)
    ){
        Text(
            text = titulo,
            modifier = modifier,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "$score",
            modifier = modifier,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier.padding(15.dp))
        Button(
            onClick = {}
        ) {
            Text(
                text = "Start",
                modifier = modifier.fillMaxWidth().padding(2.dp),
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AC3_Android_NathazhaTheme {
    }
}