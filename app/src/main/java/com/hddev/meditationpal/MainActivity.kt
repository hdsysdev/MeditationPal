package com.hddev.meditationpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hddev.meditationpal.screens.HomeScreen
import com.hddev.meditationpal.screens.MeditationScreen
import com.hddev.meditationpal.screens.SessionStartScreen
import com.hddev.meditationpal.ui.theme.MeditationPalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationPalTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RootNavController()
                }
            }
        }
    }
}

@Composable
fun RootNavController(){
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("start_session") { SessionStartScreen() }
        composable("meditation") { MeditationScreen(navController = navController) }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeditationPalTheme {
        Greeting("Android")
    }
}