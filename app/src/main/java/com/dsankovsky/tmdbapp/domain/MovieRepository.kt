package com.dsankovsky.tmdbapp.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getPopularMoviesList(): Flow<PagingData<MoviesList.Movie>>

    suspend fun getMovieDetails(movieId: Int): MovieDetails

}