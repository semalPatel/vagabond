package com.constraint.vagabond.main.search.adapter

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.constraint.vagabond.R
import com.squareup.picasso.Picasso

class AreaHolder internal constructor(view: View) : RecyclerView.ViewHolder(view), AreaHolderView {

    private val areaName: TextView = view.findViewById(R.id.area_name)
    private val moreInfoBtn: Button = view.findViewById(R.id.more_info)
    private val backgroundImage: ImageView = view.findViewById(R.id.card_background)

    override fun setAreaTitle(areaTitle: String) {
        areaName.text = areaTitle
    }

    override fun setAreaImage(imageUrl: String?) {
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.baseline_report_problem_24)
                .fit()
                .centerCrop()
                .into(backgroundImage)
    }

    override fun setMoreInfoButton() {}
}
