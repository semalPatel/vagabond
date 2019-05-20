package com.sierra.vagabond.main.search.adapter

import com.sierra.vagabond.data.entities.RecreationalArea

interface AreaHolderView {

    fun setAreaTitle(areaTitle: String)

    fun setAreaImage(imageUrl: String?)

    fun setMoreInfoButton(area : RecreationalArea)
}
