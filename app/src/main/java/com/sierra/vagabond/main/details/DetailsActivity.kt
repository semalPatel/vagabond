package com.sierra.vagabond.main.details

import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.main.details.adapter.DetailsPhotosAdapter
import com.sierra.vagabond.main.details.adapter.FacilitiesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    private lateinit var detailedArea: RecreationalArea

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detailedArea = intent.getParcelableExtra("area")
        setSupportActionBar(toolbar_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        initializeData()
        loadImage()
        setFacilities()
        //    setDataToRecyclerView();
    }

    private fun loadImage() {
        val expandingImage = findViewById<ImageView>(R.id.collapsing_image)
        Picasso.get().load(detailedArea.recAreaMediaList[0].imageURL).fit().centerCrop().into(expandingImage)
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

    private fun initializeData() {
        collapsing_layout.title = detailedArea.recAreaName
        val desc = detailedArea.recAreaDescription
        description.text = desc
    }

    private fun setFacilities() {
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list_facilities.layoutManager = linearLayoutManager
        val facilities = detailedArea.recAreaFacilities
        val facilitiesAdapter = FacilitiesAdapter(facilities)
        list_facilities.adapter = facilitiesAdapter
    }

    override fun setDataToRecyclerView(imageUrls: List<String>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontal_recycler_view.layoutManager = linearLayoutManager
        val detailsPhotosAdapter = DetailsPhotosAdapter(imageUrls)
        horizontal_recycler_view.adapter = detailsPhotosAdapter
    }
}
