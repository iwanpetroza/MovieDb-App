package com.petroza.mandiri.exercise.moviedbapp.home.presenter

import com.petroza.mandiri.exercise.moviedbapp.home.data.model.TopResults

interface TopRatedContract {

    interface TopRatedView {
        fun showLoading()
        fun hideLoading()
        fun showTopRatedMovies(topMovies: List<TopResults>)
        fun showErrorData(message: String)
    }

    interface TopRatedPresenter {
        fun getRequestTopMovies()
        fun getSearchMoviesWithTitle(title: String)
    }

    interface TopRatedData {
        fun onSuccessDataResponse(topRatedMovies: List<TopResults>)
        fun onErrorDataResponse(message: String)
    }
}