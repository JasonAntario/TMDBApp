package com.dsankovsky.tmdbapp.domain

data class MoviesList(
    val page: Int,
    val moviesList: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
) {
    data class Movie(
        val adult: Boolean,
        val backdropPath: String?,
        val genreIds: List<Int>,
        val id: Int,
        val originalLanguage: String,
        val originalTitle: String,
        val overview: String,
        val popularity: Double,
        val posterPath: String,
        val title: String,
        val video: Boolean,
        val voteAverage: Double,
        val voteCount: Int
    )
}