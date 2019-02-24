package com.constraint.vagabond.data.local;

import android.content.Context;

import com.constraint.vagabond.data.DataConverter;
import com.constraint.vagabond.data.RecreationalArea;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {RecreationalArea.class}, version = 1, exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class RecAreaDatabase extends RoomDatabase {

    private static RecAreaDatabase INSTANCE;

    public abstract RecAreaDao recAreaDao();

    private static final Object sLock = new Object();

    public static RecAreaDatabase getInstance(final Context context){
        synchronized (sLock){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RecAreaDatabase.class, "Areas.db")
                        .build();
            }
        }
        return INSTANCE;
    }
}
