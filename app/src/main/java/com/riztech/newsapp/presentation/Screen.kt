package com.riztech.newsapp.presentation

sealed class Screen(val route: String){
    object NewsList: Screen("news_list_screen")
    object NewsDetail: Screen("news_detail_screen")
}
