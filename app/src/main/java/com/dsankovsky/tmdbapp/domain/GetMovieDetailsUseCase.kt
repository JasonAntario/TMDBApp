package com.dsankovsky.tmdbapp.domain

class GetMovieDetailsUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movieId: Int) = repository.getMovieDetails(movieId)
}