package com.sierra.vagabond.main.details;

import java.util.List;

public class DetailsPresenterImpl implements DetailsContract.Presenter {

  public DetailsContract.View view;

  public DetailsPresenterImpl(DetailsContract.View view) {
    this.view = view;
  }

  @Override
  public void loadImages(List<String> imageUrls) {
    view.setDataToRecyclerView(imageUrls);
  }

  @Override
  public void loadAreaDescription(String recAreaName) {}

  @Override
  public void areaDirections(String recAreaName) {}
}
