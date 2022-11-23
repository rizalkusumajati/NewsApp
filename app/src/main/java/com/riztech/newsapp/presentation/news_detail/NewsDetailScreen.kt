package com.riztech.newsapp.presentation.news_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NewsDetailScreen(
     viewModel: NewsDetailViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
        Text(
            modifier = Modifier
                .fillMaxWidth()
            ,
            style = MaterialTheme.typography.h6,
            text = "${state.article.title}"
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Author : ${state.article.author}", style = MaterialTheme.typography.caption)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "${state.article.content}")


    }
}