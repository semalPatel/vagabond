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

    private var progressBar: ProgressBar? = null
    private var presenter: MainContract.presenter? = null
    private var errorSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeToolbarAndRecyclerView()
        initProgressBar()
        presenter = MainPresenterImpl(this)
    }

    private fun initializeToolbarAndRecyclerView() {
        setSupportActionBar(main_app_toolbar)
        main_app_toolbar.setTitle(R.string.app_name)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewID!!.layoutManager = layoutManager
    }

    private fun initProgressBar() {
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        progressBar!!.isIndeterminate = true
        val relativeLayout = RelativeLayout(this)
        relativeLayout.gravity = Gravity.CENTER
        relativeLayout.addView(progressBar)
        val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        progressBar!!.visibility = View.INVISIBLE
        this.addContentView(relativeLayout, params)
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.INVISIBLE
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
        presenter!!.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu.findItem(R.id.app_bar_search)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = android.R.attr.maxWidth
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(s: String): Boolean {
        presenter!!.onSearch(s, getString(R.string.api_key))
        return false
    }

    override fun onQueryTextChange(s: String): Boolean {
        return false
    }
}
