package com.sierra.vagabond.main.details

class DetailsPresenterImpl(var view: DetailsContract.View) : DetailsContract.Presenter {

    override fun loadImages(imageUrls: List<String>) {
        view.setDataToRecyclerView(imageUrls)
    }

    override fun loadAreaDescription(recAreaName: String) {}

    override fun areaDirections(recAreaName: String) {}
}