package com.sierra.vagabond.main.search.adapter

import com.sierra.vagabond.data.entities.RecreationalAreaList

class AreaAdapterPresenter(private val recreationalAreaList: RecreationalAreaList) {

    internal val areaCount: Int
        get() = recreationalAreaList.areasList.size

    internal fun onBindDataToAdapter(holder: AreaHolder, position: Int) {
        val area = recreationalAreaList.areasList[position]
        holder.setAreaTitle(area.recAreaName)
        val imageUrl: String? = if (area.recAreaMediaList.isEmpty()) null else area.recAreaMediaList[0].imageURL
        holder.setAreaImage(imageUrl)
        holder.setMoreInfoButton(area)
    }
}
