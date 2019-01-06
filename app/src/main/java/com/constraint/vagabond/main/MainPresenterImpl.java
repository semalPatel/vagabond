package com.constraint.vagabond.main;

import com.constraint.vagabond.data.RecreationalArea;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImpl
    implements MainContract.presenter, MainContract.GetRecAreasInteractor.OnFinishedListener {

  private MainContract.MainView mainView;
  private MainContract.GetRecAreasInteractor getRecAreasInteractor;

  public MainPresenterImpl(
      MainContract.MainView mainView, MainContract.GetRecAreasInteractor getRecAreasInteractor) {

    this.mainView = mainView;
    this.getRecAreasInteractor = getRecAreasInteractor;
  }

  @Override
  public void onDestroy() {
    mainView = null;
  }

  @Override
  public void onSearch(String s) {
    if (mainView != null) {
      mainView.showProgress();
    }
    getRecAreasInteractor.getRecAreasList(this, s);
  }

  @Override
  public void onFinished(List<RecreationalArea> recAreasList) {
    if (mainView != null) {
      mainView.setDataToRecyclerView(recAreasList);
      mainView.hideProgress();
    }
  }

  @Override
  public void onFailure(Throwable t) {
    if (mainView != null) {
      mainView.onResponseFailure(t);
      mainView.hideProgress();
    }
  }
}
