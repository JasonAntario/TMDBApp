package com.dsankovsky.tmdbapp.data

import com.dsankovsky.tmdbapp.domain.MoviesList

class MovieMapper {

    fun mapMoviesResultDaoToMoviesResult(movieDao: MoviesListDao.MovieDao) = MoviesList.Movie(
        adult = movieDao.adult,
        backdropPath = movieDao.backdropPath,
        genreIds = movieDao.genreIds,
        id = movieDao.id,
        originalLanguage = movieDao.originalLanguage,
        originalTitle = movieDao.originalTitle,
        overview = movieDao.overview,
        popularity = movieDao.popularity,
        posterPath = movieDao.posterPath,
        title = movieDao.title,
        video = movieDao.video,
        voteAverage = movieDao.voteAverage,
        voteCount = movieDao.voteCount
    )
}