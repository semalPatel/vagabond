package com.sierra.vagabond.main.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.entities.RecAreaFacilities
import kotlinx.android.synthetic.main.list_facilities.view.*

class FacilitiesAdapter(private val facilities: List<RecAreaFacilities>) : RecyclerView.Adapter<FacilitiesAdapter.Facilities>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Facilities {
        return Facilities(
                LayoutInflater.from(parent.context).inflate(R.layout.list_facilities, parent, false))
    }

    override fun onBindViewHolder(holder: Facilities, position: Int) {
        holder.facilityName.text = facilities[position].facilityName
    }

    override fun getItemCount(): Int {
        return facilities.size
    }

    inner class Facilities(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val facilityName: TextView = itemView.facility_name
    }
}