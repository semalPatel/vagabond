package com.constraint.vagabond.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.constraint.vagabond.data.entities.DataConverter;
import com.constraint.vagabond.data.entities.RecreationalArea;

@Database(
    entities = {RecreationalArea.class},
    version = 1,
    exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class RecAreaDatabase extends RoomDatabase {

  private static final Object sLock = new Object();
  private static RecAreaDatabase INSTANCE;

  public static RecAreaDatabase getInstance(final Context context) {
    synchronized (sLock) {
      if (INSTANCE == null) {
        INSTANCE =
            Room.databaseBuilder(context.getApplicationContext(), RecAreaDatabase.class, "Areas.db")
                .build();
      }
    }
    return INSTANCE;
  }

  public abstract RecAreaDao recAreaDao();

  public void destroyDB() {
    INSTANCE = null;
  }
}
