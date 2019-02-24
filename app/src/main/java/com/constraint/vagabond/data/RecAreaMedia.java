package com.constraint.vagabond.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class RecAreaMedia {

  @SerializedName("Title")
  @Expose
  public final String imageTitle;

  @SerializedName("Height")
  @Expose
  public final Integer imageHeight;

  @SerializedName("Width")
  @Expose
  public final Integer imageWidth;

  @SerializedName("URL")
  @Expose
  public final String imageURL;

  public RecAreaMedia(String imageTitle, Integer imageHeight, Integer imageWidth, String imageURL) {

    this.imageTitle = imageTitle;
    this.imageHeight = imageHeight;
    this.imageWidth = imageWidth;
    this.imageURL = imageURL;
  }
}
