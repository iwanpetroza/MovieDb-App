package com.petroza.mandiri.exercise.moviedbapp.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.petroza.mandiri.exercise.moviedbapp.R
import com.petroza.mandiri.exercise.moviedbapp.home.view.HomeActivity
import com.petroza.mandiri.exercise.moviedbapp.login.data.UserPreferenceManager
import com.petroza.mandiri.exercise.moviedbapp.login.presenter.LoginContract
import com.petroza.mandiri.exercise.moviedbapp.login.presenter.LoginPresenter
import com.petroza.mandiri.exercise.moviedbapp.login.resources.LoginResources
import com.petroza.mandiri.exercise.moviedbapp.utils.alertDialog
import com.petroza.mandiri.exercise.moviedbapp.utils.hide
import com.petroza.mandiri.exercise.moviedbapp.utils.show
import com.petroza.mandiri.exercise.moviedbapp.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private lateinit var loginPresenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        loginPresenter = LoginPresenter(
            this,
            LoginResources(this),
            UserPreferenceManager()
        )

        btnLogin.setOnClickListener {
            loginPresenter.login(
                txtInputEditUser.text.toString(),
                txtInputEditPassword.text.toString()
            )
        }
    }

    override fun showLoading() {
        progressBarLogin.show()
    }

    override fun hideLoading() {
        progressBarLogin.hide()
    }

    override fun onSuccessLogin(message: String) {
        toast(message)
        HomeActivity.launch(this)
    }

    override fun showErrorMessage(message: String) {
        val title =  getString(R.string.app_name)
        val btnLabel = getString(R.string.btn_ok)
        alertDialog(title, message, btnLabel)
    }
}