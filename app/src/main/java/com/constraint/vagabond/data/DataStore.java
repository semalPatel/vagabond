package com.constraint.vagabond.data;

import com.constraint.vagabond.data.entities.RecreationalAreaList;

public class DataStore {

  private static RecreationalAreaList recreationalAreaList;

  public DataStore(RecreationalAreaList recreationalAreaList) {}

  public static RecreationalAreaList getRecreationalAreaList() {
    return recreationalAreaList;
  }

  public static synchronized void setRecreationalAreaList(RecreationalAreaList list) {
    recreationalAreaList = list;
  }
}
