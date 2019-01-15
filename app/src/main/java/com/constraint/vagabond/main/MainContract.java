package com.constraint.vagabond.main;

import com.constraint.vagabond.data.RecreationalAreaList;

public interface MainContract {

  interface presenter {

    void onDestroy();

    void onSearch(String query);
  }

  interface MainView {

    void showProgress();

    void hideProgress();

    void setDataToRecyclerView(RecreationalAreaList recAreasList);

    void onResponseFailure(Throwable throwable);
  }

  interface GetRecAreasInteractor {

    void getRecAreasList(OnFinishedListener onFinishedListener, String query);

    interface OnFinishedListener {

      void onFinished(RecreationalAreaList recAreasList);

      void onFailure(Throwable t);
    }
  }
}
