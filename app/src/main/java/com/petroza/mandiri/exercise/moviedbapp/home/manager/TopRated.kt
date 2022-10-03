package com.petroza.mandiri.exercise.moviedbapp.home.manager

import com.petroza.mandiri.exercise.moviedbapp.detail.presenter.DetailContract
import com.petroza.mandiri.exercise.moviedbapp.home.presenter.TopRatedContract

interface TopRated {

    fun getMoviesTopRated(topRatedData: TopRatedContract.TopRatedData)

    fun getMoviesSearch(search: String, topRatedData: TopRatedContract.TopRatedData)

    fun getMoviesPopular(topRatedData: TopRatedContract.TopRatedData)

    fun getMoviesUpcoming(topRatedData: TopRatedContract.TopRatedData)

    fun getMovieDetail(idMovie: String, detailData: DetailContract.DetailData)
}