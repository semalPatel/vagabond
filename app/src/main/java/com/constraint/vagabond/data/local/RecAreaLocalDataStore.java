package com.constraint.vagabond.data.local;

import com.constraint.vagabond.data.RecAreaDataSource;
import com.constraint.vagabond.data.entities.RecreationalArea;

import java.util.List;

public class RecAreaLocalDataStore implements RecAreaDataSource {

  @Override
  public void save(List<RecreationalArea> recreationalAreaList) {}

  @Override
  public List<RecreationalArea> getAreas() {
    return null;
  }

  @Override
  public RecreationalArea getArea(String rec_area_id) {
    return null;
  }
}
