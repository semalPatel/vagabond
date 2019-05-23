package com.sierra.vagabond.main.details.adapter

import android.annotation.TargetApi
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.SearchRepositoryProvider
import com.sierra.vagabond.data.entities.RecAreaFacilities
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.utils.Prefs
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.list_facilities.view.*
import java.time.Instant

class FacilitiesAdapter(private val facilities: List<RecAreaFacilities>) : RecyclerView.Adapter<FacilitiesAdapter.Facilities>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Facilities {
        return Facilities(
                LayoutInflater.from(parent.context).inflate(R.layout.list_facilities, parent, false))
    }

    @TargetApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: Facilities, position: Int) {
        holder.facilityName.text = facilities[position].facilityName
        holder.facilityClick.setOnClickListener {
            val service = SearchRepositoryProvider.provideSierraService()
            val today = Instant.now()
            val watch = WatchRequest(
                    facilityId = facilities[position].facilityId,
                    facilityName = facilities[position].facilityName,
                    startDate = 1558573331,
                    watchToken = Prefs.deviceRegistrationToken
            )
            service
                    .createWatch(watch)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { result -> Log.d(javaClass.simpleName, result.toString()) },
                            { error -> Log.d(javaClass.simpleName, error.message) })
        }

    }

    override fun getItemCount(): Int {
        return facilities.size
    }

    inner class Facilities(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val facilityName: TextView = itemView.facility_name
        val facilityClick: CardView = itemView.facilities_background
    }
}