package com.sierra.vagabond.main.search.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sierra.vagabond.R
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.main.details.DetailsActivity
import com.sierra.vagabond.utils.REC_AREA_ID
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_view.view.*

class AreaHolder(private val view: View) : RecyclerView.ViewHolder(view), AreaHolderView {

    override fun setAreaTitle(areaTitle: String) {
        view.area_name.text = areaTitle
    }

    override fun setAreaImage(imageUrl: String?) {
        Picasso.get()
                .load(imageUrl)
                .error(R.drawable.baseline_report_problem_24)
                .fit()
                .centerCrop()
                .into(view.card_background)
    }

    override fun setMoreInfoButton(area: RecreationalArea) {
        view.main_card.setOnClickListener { v -> goToDetailsActivity(v, area) }
    }

    private fun goToDetailsActivity(v: View, area: RecreationalArea) {
        val intent = Intent(v.context, DetailsActivity::class.java)
        intent.putExtra(REC_AREA_ID, area.recAreaID)
        v.context.startActivity(intent)
    }
}
