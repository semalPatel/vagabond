package com.constraint.vagabond.data;

public class DataStore {

    private static RecreationalAreaList recreationalAreaList;

    public synchronized static void setRecreationalAreaList(RecreationalAreaList list) {
        recreationalAreaList = list;
    }

    public static RecreationalAreaList getRecreationalAreaList() {
        return recreationalAreaList;
    }

}
