package com.riztech.newsapp.domain.use_case

import com.riztech.newsapp.common.Resource
import com.riztech.newsapp.data.remote.dto.toDomain
import com.riztech.newsapp.domain.model.Article
import com.riztech.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository
){
    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        try {
            emit(Resource.Loading())
            val articles = repository.getTopHeadline()
            emit(Resource.Success(articles.toDomain()))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server check your internet connection"))
        }
    }
}