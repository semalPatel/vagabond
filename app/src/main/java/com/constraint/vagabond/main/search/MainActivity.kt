package com.constraint.vagabond.main.search

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.constraint.vagabond.R
import com.constraint.vagabond.data.entities.RecreationalAreaList
import com.constraint.vagabond.main.search.adapter.RecreationalAreaAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.MainView, SearchView.OnQueryTextListener {

    private lateinit var presenter: MainContract.Presenter
    private var errorSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeToolbarAndRecyclerView()
        presenter = MainPresenterImpl(this)
    }

    private fun initializeToolbarAndRecyclerView() {
        setSupportActionBar(main_app_toolbar)
        main_app_toolbar.setTitle(R.string.app_name)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewID.layoutManager = layoutManager
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.INVISIBLE
    }

    override fun onResponseFailure() {
        errorSnackBar = Snackbar.make(layout_id, R.string.area_error, Snackbar.LENGTH_INDEFINITE)
        errorSnackBar?.show()
    }

    override fun setDataToRecyclerView(recAreasList: RecreationalAreaList) {
        val recreationalAreaAdapter = RecreationalAreaAdapter(recAreasList)
        recyclerViewID!!.adapter = recreationalAreaAdapter
        Log.d(MainActivity::class.java.simpleName, recAreasList.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu.findItem(R.id.app_bar_search)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = android.R.attr.maxWidth
        searchView.queryHint = getString(R.string.national_park_hint)
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(s: String): Boolean {
        presenter.onSearch(s, getString(R.string.api_key))
        return false
    }

    override fun onQueryTextChange(s: String): Boolean {
        return false
    }



}
