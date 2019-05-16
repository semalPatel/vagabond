package com.constraint.vagabond.data.entities;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {

  @TypeConverter
  public String fromRecreationalAreaMedia(List<RecAreaMedia> recAreaMediaList) {
    if (recAreaMediaList == null) {
      return null;
    }
    Gson gson = new Gson();
    Type type = new TypeToken<List<RecAreaMedia>>() {}.getType();
    String json = gson.toJson(recAreaMediaList, type);
    return json;
  }

  @TypeConverter
  public List<RecAreaMedia> toRecreationalAreaMedia(String json) {
    if (json == null) {
      return null;
    }
    Gson gson = new Gson();
    Type type = new TypeToken<List<RecAreaMedia>>() {}.getType();
    List<RecAreaMedia> recreationalAreaMedia = gson.fromJson(json, type);
    return recreationalAreaMedia;
  }
}
