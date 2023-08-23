package com.example.pagingexample4.data

data class GithubSearchResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<Items>,
)
