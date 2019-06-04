package com.sierra.vagabond.main.details

class DetailsPresenter(var view: DetailsMvp.View) : DetailsMvp.Presenter {

    override fun loadImages(imageUrls: List<String>) {
        view.setDataToRecyclerView(imageUrls)
    }

    override fun loadAreaDescription(recAreaName: String) {}

    override fun areaDirections(recAreaName: String) {}
}
