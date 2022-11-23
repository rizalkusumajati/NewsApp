package com.riztech.newsapp.presentation.news_detail.components

import com.riztech.newsapp.domain.model.Article

data class NewsDetailState(
    val article: Article = Article()
)
