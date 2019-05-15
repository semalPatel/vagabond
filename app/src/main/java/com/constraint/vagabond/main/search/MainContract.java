package com.constraint.vagabond.main.search;

import com.constraint.vagabond.data.entities.RecreationalAreaList;

public interface MainContract {

  interface presenter {

    void onDestroy();

    void onSearch(String query, String apiKey);
  }

  interface MainView {

    void showProgress();

    void hideProgress();

    void setDataToRecyclerView(RecreationalAreaList recAreasList);

    void onResponseFailure();
  }

//  interface GetRecAreasInteractor {
//
//    void getRecAreasList(OnFinishedListener onFinishedListener, String query);
//
//    interface OnFinishedListener {
//
//      void onFinished(RecreationalAreaList recAreasList);
//
//      void onFailure(Throwable t);
//    }
//  }
}
