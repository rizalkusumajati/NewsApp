package com.riztech.newsapp.presentation.news_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.riztech.newsapp.domain.model.Article
import com.riztech.newsapp.presentation.news_detail.components.NewsDetailState
import javax.inject.Inject

class NewsDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(NewsDetailState())
    val state: State<NewsDetailState> = _state

    init {
        savedStateHandle.get<String>("article")?.let {
            val article: Article = Gson().fromJson(it, Article::class.java)
            getArticle(article)
        }
    }

    private fun getArticle(article: Article) {
        _state.value = NewsDetailState(
            article = article
        )
    }
}