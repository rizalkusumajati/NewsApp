package com.riztech.newsapp.data.repository

import com.riztech.newsapp.data.remote.NewsApi
import com.riztech.newsapp.data.remote.dto.HeadlineDto
import com.riztech.newsapp.data.remote.dto.toDomain
import com.riztech.newsapp.domain.model.Article
import com.riztech.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
): NewsRepository {
    override suspend fun getTopHeadline(): HeadlineDto {
        return api.getTopHeadlines()
    }

}