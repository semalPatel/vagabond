package com.sierra.vagabond.main.details

interface DetailsMvp {

    interface Presenter {

        fun loadImages(imageUrls: List<String>)

        fun loadAreaDescription(recAreaName: String)

        fun areaDirections(recAreaName: String)
    }

    interface View {

        fun setDataToRecyclerView(imageUrls: List<String>)

    }
}
