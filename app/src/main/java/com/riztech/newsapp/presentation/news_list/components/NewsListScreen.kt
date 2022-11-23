package com.riztech.newsapp.presentation.news_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.gson.Gson
import com.riztech.newsapp.presentation.Screen
import com.riztech.newsapp.presentation.news_list.NewsListViewModel

@Composable
fun NewsListScreen(
    navController: NavController,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ){
            items(state.newsList){ article ->
                val jsonArticle = Gson().toJson(article)
                NewsListItem(article = article, onItemClick = {
                    navController.navigate(Screen.NewsDetail.route + "/${jsonArticle}")
                })

            }
        }
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)

            )
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}