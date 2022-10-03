package com.petroza.mandiri.exercise.moviedbapp.detail.presenter

import com.petroza.mandiri.exercise.moviedbapp.detail.data.model.DetailResponse

interface DetailContract {

    interface DetailView {
        fun showDetailData(title: String, image: String,
                           overview: String, homepage: String?,
                           showShare: Int)
        fun showErrorMessage(message: String)
    }

    interface DetailPresenter {
        fun getRequestDetailMovie( idMovie: String )
    }

    interface DetailData {
        fun onSuccessDataResponse( movieDetail: DetailResponse)
        fun onErrorDataResponse( message: String )
    }
}