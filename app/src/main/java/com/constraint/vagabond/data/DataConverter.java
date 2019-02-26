package com.constraint.vagabond.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class DataConverter {

    /** type converter to do later **/
//    @TypeConverter
//    public String fromRecreationalAreaList(List<RecreationalArea> recreationalAreas){
//        if (recreationalAreas == null){
//            return null;
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<RecreationalAreaList>() {}.getType();
//        String json = gson.toJson(recreationalAreas, type);
//        return json;
//    }
//
//    @TypeConverter
//    public List<RecreationalArea> toRecreationalAreaList(String json){
//        if (json == null){
//            return null;
//        }
//        Gson gson = new Gson();
//        Type type = new TypeToken<RecreationalAreaList>() {}.getType();
//        List<RecreationalArea> recreationalAreaList = gson.fromJson(json, type);
//        return recreationalAreaList;
//    }


    @TypeConverter
    public String fromRecreationalAreaMedia(List<RecAreaMedia> recAreaMediaList){
        if (recAreaMediaList == null){
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<RecAreaMedia>>() {}.getType();
        String json = gson.toJson(recAreaMediaList, type);
        return json;
    }

    @TypeConverter
    public List<RecAreaMedia> toRecreationalAreaMedia(String json){
        if (json == null){
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<RecAreaMedia>>() {}.getType();
        List<RecAreaMedia> recreationalAreaMedia = gson.fromJson(json, type);
        return recreationalAreaMedia;
    }


}
