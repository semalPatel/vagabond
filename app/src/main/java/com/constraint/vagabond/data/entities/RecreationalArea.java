package com.constraint.vagabond.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public final class RecreationalArea {

  @PrimaryKey
  @NonNull
  @SerializedName("RecAreaID")
  @Expose
  public final String recAreaID;

  @SerializedName("RecAreaName")
  @Expose
  public final String recAreaName;

  @SerializedName("RecAreaDescription")
  @Expose
  public final String recAreaDescription;

  @SerializedName("RecAreaDirections")
  @Expose
  public final String recAreaDirections;

  @SerializedName("RecAreaPhone")
  @Expose
  public final String recAreaPhone;

  @SerializedName("RecAreaEmail")
  @Expose
  public final String recAreaEmail;

  @SerializedName("MEDIA")
  @Expose
  @TypeConverters(DataConverter.class)
  public final List<RecAreaMedia> recAreaMediaList;

  public RecreationalArea(
      String recAreaID,
      String recAreaName,
      String recAreaDescription,
      String recAreaDirections,
      String recAreaPhone,
      String recAreaEmail,
      List<RecAreaMedia> recAreaMediaList) {
    this.recAreaID = recAreaID;
    this.recAreaName = recAreaName;
    this.recAreaDescription = recAreaDescription;
    this.recAreaDirections = recAreaDirections;
    this.recAreaPhone = recAreaPhone;
    this.recAreaEmail = recAreaEmail;
    this.recAreaMediaList = recAreaMediaList;
  }

  @NonNull
  @Override
  public String toString() {
    String info = "id: " + recAreaID +
            "\n" + "name: " + recAreaName +
            "\n" + "description: " + recAreaDescription +
            "\n" + "directions: " + recAreaDirections +
            "\n" + "phone: " + recAreaPhone +
            "\n" + "email: " + recAreaEmail +
            "\n" + "media_urls" + recAreaMediaList.toString();
    return info;
  }
}
