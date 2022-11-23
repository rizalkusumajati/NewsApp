package com.riztech.newsapp.presentation.news_list

import com.riztech.newsapp.domain.model.Article

data class NewsListState(
    val isLoading: Boolean = false,
    val newsList: List<Article> = emptyList(),
    val error: String = ""
)
