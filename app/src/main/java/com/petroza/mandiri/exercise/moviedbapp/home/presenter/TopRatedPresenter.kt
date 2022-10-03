package com.petroza.mandiri.exercise.moviedbapp.home.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.MoviesRoomDatabase
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.entity.Movies
import com.petroza.mandiri.exercise.moviedbapp.home.data.model.TopResults
import com.petroza.mandiri.exercise.moviedbapp.home.manager.TopRated

class TopRatedPresenter (
    private val topRatedView: TopRatedContract.TopRatedView,
    private val topRated: TopRated
): TopRatedContract.TopRatedPresenter, TopRatedContract.TopRatedData {

    init {
        getRequestTopMovies()
    }

    override fun getRequestTopMovies() {
        topRatedView.showLoading()
        topRated.getMoviesTopRated(this)

    }

    override fun getSearchMoviesWithTitle(title: String) {
        topRatedView.showLoading()
        topRated.getMoviesSearch(title, this)
    }

    override fun onSuccessDataResponse(topRatedMovies: List<TopResults>) {
        topRatedView.hideLoading()
        topRatedView.showTopRatedMovies(topRatedMovies)
    }

    override fun onErrorDataResponse(message: String) {
        topRatedView.hideLoading()
        topRatedView.showErrorData(message)
    }

}