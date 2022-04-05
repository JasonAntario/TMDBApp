package com.dsankovsky.tmdbapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dsankovsky.tmdbapp.data.MovieRepositoryImpl
import com.dsankovsky.tmdbapp.domain.GetPopularMoviesListUseCase

class MovieViewModel : ViewModel() {

    private val repository = MovieRepositoryImpl()

    private val getPopularMoviesListUseCase = GetPopularMoviesListUseCase(repository)

    fun getPopularMovies() = getPopularMoviesListUseCase().cachedIn(viewModelScope)
}