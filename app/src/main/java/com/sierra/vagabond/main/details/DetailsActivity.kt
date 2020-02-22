package com.sierra.vagabond.main.details

import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.main.details.adapter.DetailsPhotosAdapter
import com.sierra.vagabond.main.details.adapter.FacilitiesAdapter
import com.sierra.vagabond.utils.REC_AREA_ID
import com.sierra.vagabond.viewmodels.DetailsActivityViewModel
import com.sierra.vagabond.viewmodels.DetailsViewModelFactory
import com.sierra.vagabond.viewmodels.MainViewModelFactory
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsMvp.View {

    @Inject
    lateinit var viewModelFactory: DetailsViewModelFactory

    private val detailsViewModel: DetailsActivityViewModel by viewModels { viewModelFactory }

    private lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        id = intent.getStringExtra(REC_AREA_ID)
        setSupportActionBar(toolbar_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        detailsViewModel.area.observe(this, Observer { area ->
            initializeData(area)
        })
        detailsViewModel.getSingleArea(id)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun initializeData(detailedArea: RecreationalArea) {
        val expandingImage = findViewById<ImageView>(R.id.collapsing_image)
        Picasso.get().load(detailedArea.recAreaMediaList[0].imageURL).fit().centerCrop().into(expandingImage)
        collapsing_layout.title = detailedArea.recAreaName
        val desc = detailedArea.recAreaDescription
        description.text = desc
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list_facilities.layoutManager = linearLayoutManager
        val facilities = detailedArea.recAreaFacilities
        val facilitiesAdapter = FacilitiesAdapter(facilities, detailsViewModel)
        list_facilities.adapter = facilitiesAdapter
    }

    override fun setDataToRecyclerView(imageUrls: List<String>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontal_recycler_view.layoutManager = linearLayoutManager
        val detailsPhotosAdapter = DetailsPhotosAdapter(imageUrls)
        horizontal_recycler_view.adapter = detailsPhotosAdapter
    }
}
