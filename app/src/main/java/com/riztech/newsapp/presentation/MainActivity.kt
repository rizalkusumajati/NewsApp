package com.riztech.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.riztech.newsapp.presentation.news_detail.NewsDetailScreen
import com.riztech.newsapp.presentation.news_list.components.NewsListScreen
import com.riztech.newsapp.presentation.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   val navController = rememberNavController()
                   NavHost(
                       navController = navController,
                       startDestination = Screen.NewsList.route
                   ){
                       composable(
                           route = Screen.NewsList.route
                       ){
                           NewsListScreen(navController)
                       }
                       composable(
                           route = Screen.NewsDetail.route + "/{article}",
                           arguments = listOf(
                               navArgument("article"){
                                   type = NavType.StringType
                               }
                           )
                       ){
                           NewsDetailScreen()
                       }
                   }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsAppTheme {
        Greeting("Android")
    }
}