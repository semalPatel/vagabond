package com.sierra.vagabond.data

import com.sierra.vagabond.data.entities.RecreationalArea

interface RecAreaDataSource {

    val areas: List<RecreationalArea>

    fun save(recreationalAreaList: List<RecreationalArea>)

    fun getArea(rec_area_id: String): RecreationalArea?
}
