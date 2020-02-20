package com.sierra.vagabond.main.search

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sierra.vagabond.R
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.TokenRequest
import com.sierra.vagabond.main.search.adapter.RecreationalAreaAdapter
import com.sierra.vagabond.utils.Prefs
import com.sierra.vagabond.viewmodels.RecAreasViewModel
import com.sierra.vagabond.viewmodels.RecAreasViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainController.View, SearchView.OnQueryTextListener {

    @Inject
    lateinit var presenter: MainController.ViewModel
    @Inject
    lateinit var viewModelFactory: RecAreasViewModelFactory
    @Inject
    lateinit var recAreaRepository: RecAreaRepository

    private val areasViewModel: RecAreasViewModel by viewModels { viewModelFactory }

    private var errorSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeToolbarAndRecyclerView()
        areasViewModel.areaList.observe(this, Observer { areas ->
            setDataToRecyclerView(areas)
        })
        val tokenRequest = TokenRequest(
                userId = "semal",
                fcmToken = Prefs.deviceRegistrationToken
        )
        recAreaRepository.registerToken(tokenRequest)
    }

    private fun initializeToolbarAndRecyclerView() {
        setSupportActionBar(main_app_toolbar)
        main_app_toolbar.setTitle(R.string.app_name)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        search_recycler_view.layoutManager = layoutManager
        search_recycler_view.setHasFixedSize(true)
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.INVISIBLE
    }

    override fun onResponseFailure() {
        errorSnackBar = Snackbar.make(layout_id, R.string.area_error, Snackbar.LENGTH_SHORT)
        errorSnackBar?.show()
    }

    private fun setDataToRecyclerView(recAreasList: List<RecreationalArea>) {
        val recreationalAreaAdapter = RecreationalAreaAdapter(recAreasList)
        search_recycler_view.adapter = recreationalAreaAdapter
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
        areasViewModel.getRecAreaList(s)
        return false
    }

    override fun onQueryTextChange(s: String): Boolean {
        return false
    }
}
