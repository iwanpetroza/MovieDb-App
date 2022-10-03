package com.petroza.mandiri.exercise.moviedbapp.detail.presenter

import com.petroza.mandiri.exercise.moviedbapp.detail.data.model.DetailResponse
import com.petroza.mandiri.exercise.moviedbapp.home.manager.TopRated
import com.petroza.mandiri.exercise.moviedbapp.utils.Constants.GONE
import com.petroza.mandiri.exercise.moviedbapp.utils.Constants.VISIBLE

class DetailPresenter(
    val detailView: DetailContract.DetailView,
    val topRated: TopRated
): DetailContract.DetailPresenter, DetailContract.DetailData {
    override fun getRequestDetailMovie(idMovie: String) {
        topRated.getMovieDetail(idMovie, this)
    }

    override fun onSuccessDataResponse(movieDetail: DetailResponse) {

        detailView.showDetailData(
            movieDetail.title.orEmpty(),
            "https://image.tmdb.org/t/p/w500${movieDetail.posterPath.orEmpty()}",
            movieDetail.overview.orEmpty(),
            movieDetail.homepage,
            if ( movieDetail.homepage.orEmpty().isNotEmpty() ) {
                VISIBLE
            } else {
                GONE
            })
    }

    override fun onErrorDataResponse(message: String) {
        detailView.showErrorMessage(message)
    }
}