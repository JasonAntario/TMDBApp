package com.dsankovsky.tmdbapp.data.network

import com.dsankovsky.tmdbapp.data.MovieDetailsDao
import com.dsankovsky.tmdbapp.data.MoviesListDao
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query ("api_key") apiKey: String = ApiFactory.API_KEY
    ): MoviesListDao

    @GET("movie")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query ("api_key") apiKey: String = ApiFactory.API_KEY
    ): MovieDetailsDao
}