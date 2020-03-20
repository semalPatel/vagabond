package com.sierra.vagabond.main.details.adapter

import android.annotation.TargetApi
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.datePicker
import com.sierra.vagabond.R
import com.sierra.vagabond.data.entities.RecAreaFacilities
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.viewmodels.DetailsActivityViewModel
import kotlinx.android.synthetic.main.list_facilities.view.*
import java.time.Instant
import java.util.*

class FacilitiesAdapter(private val facilities: List<RecAreaFacilities>,
                        private val detailsViewModel: DetailsActivityViewModel) : RecyclerView.Adapter<FacilitiesAdapter.Facilities>() {

    private var startDate: Instant? = null
    private var endDate: Instant? = null

    private val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Facilities {
        return Facilities(
                LayoutInflater.from(parent.context).inflate(R.layout.list_facilities, parent, false))
    }

    @TargetApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: Facilities, position: Int) {
        holder.facilityName.text = facilities[position].facilityName
        holder.facilityClick.setOnClickListener { v ->
            MaterialDialog(v.context).show {
                title(R.string.start_date_dialogue_title)
                datePicker(requireFutureDate = true) { dialog, date->
                    calendar.time = date.time
                    startDate = calendar.toInstant()
                }
                positiveButton {
                    MaterialDialog(it.windowContext).show {
                        title(R.string.end_date_dialogue_title)
                        datePicker { dialog2, date2->
                            calendar.time = date2.time
                            endDate = date2.toInstant()
                        }
                        positiveButton {
                            val watchRequest = WatchRequest(
                                    userId = "semal",
                                    facilityId = facilities[position].facilityId,
                                    facilityName = facilities[position].facilityName,
                                    startDate = startDate?.toString(),
                                    endDate = endDate?.toString())
                            detailsViewModel.createWatch(watchRequest)
                        }
                    }
                }
            }
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