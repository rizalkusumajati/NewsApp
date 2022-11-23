package com.riztech.newsapp.data.remote.dto

data class HeadlineDto(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)

fun HeadlineDto.toDomain() = articles.map { it.toArticle() }