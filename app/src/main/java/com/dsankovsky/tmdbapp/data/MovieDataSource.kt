package com.dsankovsky.tmdbapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.dsankovsky.tmdbapp.data.MoviesListDao.MovieDao
import com.dsankovsky.tmdbapp.data.network.ApiFactory
import okio.IOException

class MovieDataSource : PagingSource<Int, MovieDao>() {

    override fun getRefreshKey(state: PagingState<Int, MovieDao>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDao> {
        return try {

            val nextPage = params.key ?: 1
            val moviesListDao = ApiFactory.API_SERVICE.getPopularMovies(nextPage)

            LoadResult.Page(
                data = moviesListDao.moviesList,
                prevKey = null,
                nextKey = if (nextPage == 500) null else moviesListDao.page + 1
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}