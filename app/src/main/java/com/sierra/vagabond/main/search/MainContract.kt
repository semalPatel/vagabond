package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.entities.RecreationalAreaList

interface MainContract {

    interface Presenter {

        fun onDestroy()

        fun onSearch(query: String, apiKey: String)
    }

    interface MainView {

        fun showProgress()

        fun hideProgress()

        fun setDataToRecyclerView(recAreasList: RecreationalAreaList)

        fun onResponseFailure()
    }
}
