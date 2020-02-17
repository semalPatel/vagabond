package com.sierra.vagabond.main.search

interface MainMvp {

    interface Presenter {

        fun onDestroy()

        fun onSearch(query: String)
    }

    interface View {

        fun showProgress()

        fun hideProgress()

//        fun setDataToRecyclerView(recAreasList: RecreationalAreaList)

        fun onResponseFailure()

//        fun provideContext(): Context
    }
}
