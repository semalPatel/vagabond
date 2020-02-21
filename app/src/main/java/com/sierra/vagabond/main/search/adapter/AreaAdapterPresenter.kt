package com.sierra.vagabond.main.search.adapter

import com.sierra.vagabond.data.entities.RecreationalArea

class AreaAdapterPresenter(private val recreationalAreaList: Sequence<RecreationalArea>) {

    internal val areaCount: Int
        get() = recreationalAreaList.count()

    internal fun onBindDataToAdapter(holder: AreaHolder, position: Int) {
        val area = recreationalAreaList.elementAt(index = position)
        holder.setAreaTitle(area.recAreaName)
        val imageUrl: String? = if (area.recAreaMediaList.isEmpty()) null else area.recAreaMediaList[0].imageURL
        holder.setAreaImage(imageUrl)
        holder.setMoreInfoButton(area)
    }
}
