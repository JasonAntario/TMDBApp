package com.dsankovsky.tmdbapp.domain

class GetPopularMoviesListUseCase(private val repository: MovieRepository) {

    operator fun invoke() = repository.getPopularMoviesList()
}