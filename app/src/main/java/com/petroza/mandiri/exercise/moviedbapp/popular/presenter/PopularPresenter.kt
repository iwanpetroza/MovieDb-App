package com.petroza.mandiri.exercise.moviedbapp.popular.presenter

import com.petroza.mandiri.exercise.moviedbapp.home.data.model.TopResults
import com.petroza.mandiri.exercise.moviedbapp.home.manager.TopRated
import com.petroza.mandiri.exercise.moviedbapp.home.presenter.TopRatedContract

class PopularPresenter(
    val popularView: PopularContract.PopularView,
    val topRated: TopRated
): PopularContract.PopularPresenter, TopRatedContract.TopRatedData {

    override fun getRequestPopularMovies() {
        popularView.showLoading()
        topRated.getMoviesPopular(this)
    }

    override fun onSuccessDataResponse(topRatedMovies: List<TopResults>) {
        popularView.hideLoading()
        popularView.loadPopular(topRatedMovies)
    }

    override fun onErrorDataResponse(message: String) {
        popularView.hideLoading()
        popularView.showErrorMessage(message)
    }


}