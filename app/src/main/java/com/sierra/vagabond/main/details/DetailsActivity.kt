package com.sierra.vagabond.main.details

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.sierra.vagabond.R
import com.sierra.vagabond.data.DataStore
import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    private var collapsingToolbarLayout: CollapsingToolbarLayout? = null
    private var toolbar: Toolbar? = null
    private var favButton: FloatingActionButton? = null
    private var collapsingImageUrl: String? = null
    private var areaDescription: TextView? = null
    private val detailedArea = DataStore.recreationalAreaList
    private var position: Int = 0
    private var areaImages: RecyclerView? = null
    private var directionBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val getData = intent
        collapsingImageUrl = getData.getStringExtra("image_url")
        position = getData.getIntExtra("position", 0)
        initializeView()
    }

    override fun onStart() {
        super.onStart()
        initializeData()
        loadImage()
        //    setDataToRecyclerView();
    }

    fun initializeView() {
        setContentView(R.layout.activity_detail)
        toolbar = findViewById(R.id.toolbar_title)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsingToolbarLayout = findViewById(R.id.collapsing_layout)
        areaDescription = findViewById(R.id.description)
        favButton = findViewById(R.id.fav_button)
        areaImages = findViewById(R.id.horizontal_recycler_view)
        areaDescription = findViewById(R.id.description)
        directionBtn = findViewById(R.id.directions)
    }

    fun loadImage() {
        val expandingImage = findViewById<ImageView>(R.id.collapsing_image)
        Picasso.get().load(collapsingImageUrl).fit().centerCrop().into(expandingImage)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflator = menuInflater
        inflator.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    fun initializeData() {
        collapsingToolbarLayout!!.title = detailedArea!!.recreationalAreaList[position].recAreaName
        val desc = detailedArea.recreationalAreaList[position].recAreaDescription
        areaDescription!!.text = desc
    }

    override fun setDataToRecyclerView(imageUrls: List<String>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        areaImages!!.layoutManager = linearLayoutManager
        val detailsPhotosAdapter = DetailsPhotosAdapter(imageUrls)
        areaImages!!.adapter = detailsPhotosAdapter
    }
}
