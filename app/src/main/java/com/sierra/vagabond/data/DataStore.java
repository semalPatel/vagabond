package com.sierra.vagabond.data;

import com.sierra.vagabond.data.entities.RecreationalAreaList;

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
