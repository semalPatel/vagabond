package com.sierra.vagabond.main.details

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.main.details.adapter.DetailsPhotosAdapter
import com.sierra.vagabond.main.details.adapter.FacilitiesAdapter
import com.sierra.vagabond.utils.REC_AREA_ID
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsMvp.View {

    @Inject lateinit var repo: RecAreaRepository
    private lateinit var id: String
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        id = intent.getStringExtra(REC_AREA_ID)
        getAreaFromRepo()
        setSupportActionBar(toolbar_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getAreaFromRepo() {
        val areaDisposable = repo.getSingleArea(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { gotArea ->
                            initializeData(gotArea)
                        },
                        { Log.d(javaClass.simpleName, "Null result") }
                )
        compositeDisposable.add(areaDisposable)
    }

    /*private fun loadImage() {

    }*/

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
        val facilitiesAdapter = FacilitiesAdapter(facilities)
        list_facilities.adapter = facilitiesAdapter
    }

    /*private fun setFacilities() {

    }*/

    override fun setDataToRecyclerView(imageUrls: List<String>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontal_recycler_view.layoutManager = linearLayoutManager
        val detailsPhotosAdapter = DetailsPhotosAdapter(imageUrls)
        horizontal_recycler_view.adapter = detailsPhotosAdapter
    }
}
