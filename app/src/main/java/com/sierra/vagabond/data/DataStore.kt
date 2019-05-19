package com.sierra.vagabond.data

import com.sierra.vagabond.data.entities.RecreationalAreaList

class DataStore(recreationalAreaList: RecreationalAreaList) {
    companion object {

        @set:Synchronized
        var recreationalAreaList: RecreationalAreaList? = null
    }
}
