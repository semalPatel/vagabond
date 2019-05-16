package com.constraint.vagabond.main.search.adapter

import com.constraint.vagabond.data.entities.RecreationalAreaList

class AreaAdapterPresenter internal constructor(private val recreationalAreaList: RecreationalAreaList) {

    internal val areaCount: Int
        get() = recreationalAreaList.recreationalAreaList.size

    internal fun onBindDataToAdapter(holder: AreaHolder, position: Int) {
        val (_, recAreaName, _, _, _, _, recAreaMedia) = recreationalAreaList.recreationalAreaList[position]
        holder.setAreaTitle(recAreaName)
        if (recAreaMedia.isEmpty()) {
            holder.setAreaImage(null)
        } else {
            holder.setAreaImage(recAreaMedia[0].imageURL)
        }

    }
}
