package com.constraint.vagabond.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecreationalAreaList {

    @SerializedName("RECDATA")
    @Expose
    private List<RecreationalArea> recreationalAreaList;

    public List<RecreationalArea> getRecreationalAreaList(){

        return recreationalAreaList;
    }

    public void setRecreationalAreaList(ArrayList<RecreationalArea> recreationalAreaList){

        this.recreationalAreaList = recreationalAreaList;
    }

}
