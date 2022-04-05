package com.dsankovsky.tmdbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.dsankovsky.tmdbapp.data.network.ApiFactory
import com.dsankovsky.tmdbapp.domain.MoviesList
import com.dsankovsky.tmdbapp.presentation.MovieViewModel
import com.dsankovsky.tmdbapp.ui.theme.TMDBAppTheme
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.flow.Flow

class MainActivity : ComponentActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MovieViewModel::class.java]
    }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviesList = viewModel.getPopularMovies()
        setContent {
            TMDBAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MoviesListView(moviesList)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MoviesListView(moviesList: Flow<PagingData<MoviesList.Movie>>) {

    val movieListItems: LazyPagingItems<MoviesList.Movie> =
        moviesList.collectAsLazyPagingItems()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(movieListItems.itemCount) { index ->
                movieListItems[index]?.let {
                    Surface() {
                        GlideImage(
                            imageModel = ApiFactory.BASE_IMAGE_URL + it.posterPath,
                            contentScale = ContentScale.Crop,
                            circularReveal = CircularReveal(250),
                        )
                    }
                }
            }
            movieListItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {

                    }
                    loadState.append is LoadState.Loading -> {

                    }
                    loadState.append is LoadState.Error -> {

                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TMDBAppTheme {
    }
}