package com.petroza.mandiri.exercise.moviedbapp.popular.presenter

import com.petroza.mandiri.exercise.moviedbapp.home.data.model.TopResults

interface PopularContract {

    interface PopularView {
        fun showLoading()
        fun hideLoading()
        fun loadPopular( list: List<TopResults> )
        fun showErrorMessage( message: String )
    }

    interface PopularPresenter {
        fun getRequestPopularMovies()
    }
}