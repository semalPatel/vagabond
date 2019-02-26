package com.constraint.vagabond.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;

public final class RecreationalAreaList {

  @SerializedName("RECDATA")
  @Expose
  public List<RecreationalArea> recreationalAreaList;

  public RecreationalAreaList(List<RecreationalArea> recreationalAreaList) {
    this.recreationalAreaList = recreationalAreaList;
  }

  @NonNull
  @Override
  public String toString() {
    String areas = "areas: " + recreationalAreaList.toString();
    return areas;
  }
}
