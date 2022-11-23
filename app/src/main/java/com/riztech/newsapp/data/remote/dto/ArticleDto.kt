package com.riztech.newsapp.data.remote.dto

import com.riztech.newsapp.domain.model.Article
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class ArticleDto(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceDto?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

fun ArticleDto.toArticle() = Article(
    author = author ?: "",
    content = content ?: "",
    description = description ?: "",
    publishedAt = publishedAt ?: "",
    title = title ?: "",
    url = URLEncoder.encode(url, StandardCharsets.UTF_8.toString()) ?: "",
    urlToImage = URLEncoder.encode(urlToImage, StandardCharsets.UTF_8.toString()) ?: ""
)