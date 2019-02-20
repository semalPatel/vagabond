package com.constraint.vagabond.main.search.adapter;

import com.constraint.vagabond.data.RecAreaMedia;
import com.constraint.vagabond.data.RecreationalArea;
import com.constraint.vagabond.data.RecreationalAreaList;

import java.util.List;

import androidx.annotation.NonNull;

public class AreaAdapterPresenter  {

    private final RecreationalAreaList recreationalAreaList;

    public AreaAdapterPresenter(RecreationalAreaList recreationalAreaList) {
        this.recreationalAreaList = recreationalAreaList;
    }

    public void onBindDataToAdapter(@NonNull AreaHolder holder, int position){
        RecreationalArea recreationalArea = recreationalAreaList.recreationalAreaList.get(position);
        holder.setAreaTitle(recreationalArea.recAreaName);
        final List<RecAreaMedia> recAreaMedia = recreationalArea.recAreaMediaList;
        holder.setAreaImage(recAreaMedia.get(0).imageURL);
    }

    public int getAreaCount(){
        return recreationalAreaList.recreationalAreaList.size();
    }}
