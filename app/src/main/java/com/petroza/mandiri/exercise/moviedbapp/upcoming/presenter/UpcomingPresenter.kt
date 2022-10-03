package com.petroza.mandiri.exercise.moviedbapp.upcoming.presenter

import com.petroza.mandiri.exercise.moviedbapp.home.data.model.TopResults
import com.petroza.mandiri.exercise.moviedbapp.home.manager.TopRated
import com.petroza.mandiri.exercise.moviedbapp.home.presenter.TopRatedContract

class UpcomingPresenter(
    val popularView: UpcomingContract.UpcomingView,
    val topRated: TopRated
): UpcomingContract.UpcomingPresenter, TopRatedContract.TopRatedData {

    override fun getRequestUpcomingMovies() {
        popularView.showLoading()
        topRated.getMoviesUpcoming(this)
    }

    override fun onSuccessDataResponse(topRatedMovies: List<TopResults>) {
        popularView.hideLoading()
        popularView.loadUpcoming(topRatedMovies)
    }

    override fun onErrorDataResponse(message: String) {
        popularView.hideLoading()
        popularView.showErrorMessage(message)
    }
}