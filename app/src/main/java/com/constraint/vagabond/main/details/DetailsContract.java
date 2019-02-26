package com.constraint.vagabond.main.details;

import java.util.List;

public interface DetailsContract {

  interface Presenter {

    void loadImages(List<String> imageUrls);

    void loadAreaDescription(String recAreaName);

    void areaDirections(String recAreaName);
  }

  interface View {

    void setDataToRecyclerView(List<String> imageUrls);
  }
}
