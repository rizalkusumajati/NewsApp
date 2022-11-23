package com.riztech.newsapp.domain.repository

import com.riztech.newsapp.data.remote.dto.HeadlineDto
import com.riztech.newsapp.domain.model.Article

interface NewsRepository {
    suspend fun getTopHeadline() : HeadlineDto
}