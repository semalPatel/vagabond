package com.sierra.vagabond.main.search.adapter

import com.sierra.vagabond.data.entities.RecreationalArea

class AreaAdapterPresenter(private val recreationalAreaList: List<RecreationalArea>) {

    internal val areaCount: Int
        get() = recreationalAreaList.size

    internal fun onBindDataToAdapter(holder: AreaHolder, position: Int) {
        val area = recreationalAreaList[position]
        holder.setAreaTitle(area.recAreaName)
        val imageUrl: String? = if (area.recAreaMediaList.isEmpty()) null else area.recAreaMediaList[0].imageURL
        holder.setAreaImage(imageUrl)
        holder.setMoreInfoButton(area)
    }
}
