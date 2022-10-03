package com.petroza.mandiri.exercise.moviedbapp.home.data.network

import com.petroza.mandiri.exercise.moviedbapp.detail.data.model.DetailResponse
import com.petroza.mandiri.exercise.moviedbapp.home.data.model.RatedResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RatedService {

    @GET
    fun listRatedMovies(@Url url: String): Call<RatedResponse>

    @GET
    fun detailMovie(@Url url: String): Call<DetailResponse>
}