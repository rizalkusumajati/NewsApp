package com.riztech.newsapp.presentation.news_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riztech.newsapp.common.Resource
import com.riztech.newsapp.domain.use_case.GetTopHeadlinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase
): ViewModel() {
    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state

    init {
        getHeadline()
    }
    private fun getHeadline() {
        getTopHeadlinesUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = NewsListState(
                        newsList = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = NewsListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = NewsListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}