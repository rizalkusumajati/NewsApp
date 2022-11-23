package com.riztech.newsapp.domain.model

import com.riztech.newsapp.data.remote.dto.SourceDto

data class Article(
    val author: String = "",
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val title: String = "",
    val url: String = "",
    val urlToImage: String = ""
)
