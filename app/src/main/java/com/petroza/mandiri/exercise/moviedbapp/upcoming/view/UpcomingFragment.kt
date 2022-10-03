package com.petroza.mandiri.exercise.moviedbapp.upcoming.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.petroza.mandiri.exercise.moviedbapp.R
import com.petroza.mandiri.exercise.moviedbapp.detail.view.DetailActivity
import com.petroza.mandiri.exercise.moviedbapp.home.adapter.OnItemClickListener
import com.petroza.mandiri.exercise.moviedbapp.home.adapter.TopRatedAdapter
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.MoviesRoomDatabase
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.UpcomingRoomDatabase
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.entity.Movies
import com.petroza.mandiri.exercise.moviedbapp.home.data.model.TopResults
import com.petroza.mandiri.exercise.moviedbapp.home.manager.TopRatedManager
import com.petroza.mandiri.exercise.moviedbapp.upcoming.presenter.UpcomingContract
import com.petroza.mandiri.exercise.moviedbapp.upcoming.presenter.UpcomingPresenter
import kotlinx.android.synthetic.main.fragment_popular.*
import kotlinx.android.synthetic.main.fragment_upcoming.*

class UpcomingFragment : Fragment(), UpcomingContract.UpcomingView,
    SwipeRefreshLayout.OnRefreshListener, OnItemClickListener<Movies> {

    private lateinit var presenter: UpcomingContract.UpcomingPresenter
    private lateinit var database: UpcomingRoomDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        database = UpcomingRoomDatabase.getDatabase(requireContext())
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeUpcoming?.setOnRefreshListener(this)

        presenter = UpcomingPresenter(this, TopRatedManager())
        presenter.getRequestUpcomingMovies()
    }

    override fun showLoading() {
        progressUpcoming?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressUpcoming?.visibility = View.GONE
    }

    override fun loadUpcoming(list: List<TopResults>) {
        swipeUpcoming?.isRefreshing = false

        list.forEach {
            var popular = Movies(
                    it.id,
                    it.poster,
                    it.title,
                    it.overview,
                    it.releaseDate
            )
            database.upcomingDao().insertUpcomingMovie(popular)
        }

        database.upcomingDao().allUpcoming().observe(this, Observer { items ->
            items?.let {
                rvUpcoming.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                val adapter = TopRatedAdapter(items, this)
                rvUpcoming.adapter = adapter
            }
        })

    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(activity!!, message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(item: Movies) {
        DetailActivity.launch(activity!!, item.id.toString())
    }

    override fun onRefresh() {
        presenter.getRequestUpcomingMovies()
    }


}