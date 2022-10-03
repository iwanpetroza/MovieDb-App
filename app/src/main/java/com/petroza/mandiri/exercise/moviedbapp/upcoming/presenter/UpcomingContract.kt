package com.petroza.mandiri.exercise.moviedbapp.upcoming.presenter

import com.petroza.mandiri.exercise.moviedbapp.home.data.model.TopResults

interface UpcomingContract {

    interface UpcomingView {
        fun showLoading()
        fun hideLoading()
        fun loadUpcoming( list: List<TopResults> )
        fun showErrorMessage( message: String )
    }

    interface UpcomingPresenter {
        fun getRequestUpcomingMovies()
    }
}