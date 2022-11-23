package com.riztech.newsapp.presentation.news_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.riztech.newsapp.domain.model.Article

@Composable
fun NewsListItem(
    article: Article,
    onItemClick: (Article) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(article) }
            .padding(10.dp),

    ) {
        Card(
            elevation = 10.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "${article.title}",
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "${article.description}")
            }

        }
    }
}