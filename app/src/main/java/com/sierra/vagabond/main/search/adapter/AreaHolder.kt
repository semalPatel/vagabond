package com.sierra.vagabond.main.search.adapter

import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.list_view.view.*
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.main.details.DetailsActivity
import com.sierra.vagabond.utils.AREA
import com.squareup.picasso.Picasso

class AreaHolder(private val view: View) : RecyclerView.ViewHolder(view), AreaHolderView {

    override fun setAreaTitle(areaTitle: String) {
        view.area_name.text = areaTitle
    }

    override fun setAreaImage(imageUrl: String?) {
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.baseline_report_problem_24)
                .fit()
                .centerCrop()
                .into(view.card_background)
    }

    override fun setMoreInfoButton(area : RecreationalArea) {
        view.more_info.setOnClickListener { v ->  goToDetailsActivity(v, area)}
    }

    private fun goToDetailsActivity(v : View, area : RecreationalArea) {
        val intent = Intent(v.context, DetailsActivity::class.java)
        intent.putExtra(AREA, area)
        v.context.startActivity(intent)
    }
}
