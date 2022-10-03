package com.petroza.mandiri.exercise.moviedbapp.login.presenter

interface LoginContract {

    interface LoginView {
        fun showLoading()
        fun hideLoading()
        fun onSuccessLogin(message: String)
        fun showErrorMessage(message: String)
    }

    interface LoginPresenter {
        fun login(email: String, password: String)
    }
}