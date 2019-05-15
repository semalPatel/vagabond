package com.constraint.vagabond.main.search

import com.constraint.vagabond.data.entities.RecreationalAreaList

class MainPresenterImpl(
        private var mainView: MainContract.MainView?) : MainContract.presenter {

    override fun onDestroy() {
        mainView = null
    }

    override fun onSearch(s: String) {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        getRecAreasInteractor.getRecAreasList(this, s)
    }


    //  @Override
    //  public void onFinished(RecreationalAreaList recAreasList) {
    //    if (mainView != null) {
    //      mainView.setDataToRecyclerView(recAreasList);
    //      mainView.hideProgress();
    //    }
    //  }
    //
    //  @Override
    //  public void onFailure(Throwable t) {
    //    if (mainView != null) {
    //      mainView.onResponseFailure(t);
    //      mainView.hideProgress();
    //    }
    //  }
}
