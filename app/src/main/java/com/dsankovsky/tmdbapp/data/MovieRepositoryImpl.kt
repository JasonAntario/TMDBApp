package com.dsankovsky.tmdbapp.data

import androidx.paging.*
import com.dsankovsky.tmdbapp.domain.MovieDetails
import com.dsankovsky.tmdbapp.domain.MovieRepository
import com.dsankovsky.tmdbapp.domain.MoviesList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

class MovieRepositoryImpl : MovieRepository {

    private val mapper = MovieMapper()

    override fun getPopularMoviesList(): Flow<PagingData<MoviesList.Movie>> {
        val movieListFlow = Pager(PagingConfig(pageSize = 20)) { MovieDataSource() }.flow
        return movieListFlow.mapLatest { pagingData ->
            pagingData.map {
                mapper.mapMoviesResultDaoToMoviesResult(it)
            }
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        TODO("Not yet implemented")
    }
}