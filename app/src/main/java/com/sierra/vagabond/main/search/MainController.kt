package com.sierra.vagabond.main.search

interface MainController {

    interface ViewModel {

        fun onDestroy()

        fun onSearch(query: String)
    }

    interface View {

        fun showProgress()

        fun hideProgress()

//        fun setDataToRecyclerView(recAreasList: RecreationalAreaList)

        fun onResponseFailure()

    }
}
