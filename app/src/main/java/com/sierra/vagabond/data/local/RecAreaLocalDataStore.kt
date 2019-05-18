package com.sierra.vagabond.data.local

import com.sierra.vagabond.data.RecAreaDataSource
import com.sierra.vagabond.data.entities.RecreationalArea

class RecAreaLocalDataStore : RecAreaDataSource {

    override val areas: List<RecreationalArea>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun save(recreationalAreaList: List<RecreationalArea>) {}

    override fun getArea(rec_area_id: String): RecreationalArea? {
        return null
    }
}
