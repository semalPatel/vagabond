package com.constraint.vagabond.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecreationalArea {

    @SerializedName("RecAreaID")
    @Expose
    private String recAreaID;
    @SerializedName("RecAreaName")
    @Expose
    private String recAreaName;
    @SerializedName("RecAreaDescription")
    @Expose
    private String recAreaDescription;
    @SerializedName("RecAreaDirections")
    @Expose
    private String recAreaDirections;
    @SerializedName("RecAreaPhone")
    @Expose
    private String recAreaPhone;
    @SerializedName("RecAreaEmail")
    @Expose
    private String recAreaEmail;

    public RecreationalArea(String recAreaID, String recAreaName, String recAreaDescription, String recAreaDirections, String recAreaPhone, String recAreaEmail){

        this.recAreaID = recAreaID;
        this.recAreaName = recAreaName;
        this.recAreaDescription = recAreaDescription;
        this.recAreaDirections = recAreaDirections;
        this.recAreaPhone = recAreaPhone;
        this.recAreaEmail = recAreaEmail;
    }

    public String getRecAreaID() {
        return recAreaID;
    }

    public void setRecAreaID(String recAreaID) {
        this.recAreaID = recAreaID;
    }

    public String getRecAreaName() {
        return recAreaName;
    }

    public void setRecAreaName(String recAreaName) {
        this.recAreaName = recAreaName;
    }

    public String getRecAreaDescription() {
        return recAreaDescription;
    }

    public void setRecAreaDescription(String recAreaDescription) {
        this.recAreaDescription = recAreaDescription;
    }

    public String getRecAreaDirections() {
        return recAreaDirections;
    }

    public void setRecAreaDirections(String recAreaDirections) {
        this.recAreaDirections = recAreaDirections;
    }

    public String getRecAreaPhone() {
        return recAreaPhone;
    }

    public void setRecAreaPhone(String recAreaPhone) {
        this.recAreaPhone = recAreaPhone;
    }

    public String getRecAreaEmail() {
        return recAreaEmail;
    }

    public void setRecAreaEmail(String recAreaEmail) {
        this.recAreaEmail = recAreaEmail;
    }
}
