package com.constraint.vagabond.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.constraint.vagabond.R
import com.constraint.vagabond.data.entities.RecreationalAreaList

class RecreationalAreaAdapter(recreationalAreaList: RecreationalAreaList) : RecyclerView.Adapter<AreaHolder>() {

    private val areaAdapterPresenter: AreaAdapterPresenter = AreaAdapterPresenter(recreationalAreaList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaHolder {
        return AreaHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false))
    }

    override fun onBindViewHolder(holder: AreaHolder, position: Int) {
        areaAdapterPresenter.onBindDataToAdapter(holder, position)
    }

    override fun getItemCount(): Int {
        return areaAdapterPresenter.areaCount
    }
}
