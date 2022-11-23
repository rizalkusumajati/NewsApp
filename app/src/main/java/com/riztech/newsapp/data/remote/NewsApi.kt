package com.riztech.newsapp.data.remote
import com.riztech.newsapp.data.remote.dto.HeadlineDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "id",
        @Query("apiKey") apiKey: String = "5f2d1c54834148108fbdf6b086a64f54"
    ): HeadlineDto

}