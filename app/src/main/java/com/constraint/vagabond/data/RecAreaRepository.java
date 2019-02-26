package com.constraint.vagabond.data;

import android.content.Context;
import android.os.AsyncTask;

import com.constraint.vagabond.data.entities.RecreationalArea;
import com.constraint.vagabond.data.local.RecAreaDao;
import com.constraint.vagabond.data.local.RecAreaDatabase;

import java.util.List;

public class RecAreaRepository {

  private RecAreaDao recAreaDao;
  private List<RecreationalArea> recreationalAreas;
  private RecreationalArea singleArea;

  public RecAreaRepository(Context context) {
    RecAreaDatabase db = RecAreaDatabase.getInstance(context);
    recAreaDao = db.recAreaDao();
    recreationalAreas = recAreaDao.getAreas();
  }

  public List<RecreationalArea> getAreas() {
    return recreationalAreas;
  }

  public RecreationalArea getSingleArea(String recAreaId) {
    return recAreaDao.getArea(recAreaId);
  }

  public void saveAreas(List<RecreationalArea> recreationalAreas) {
    new asyncInsertTask(recAreaDao).execute(recreationalAreas);
  }

  private static class asyncInsertTask extends AsyncTask<List<RecreationalArea>, Void, Void> {
    private RecAreaDao mRecAreaDao;

    asyncInsertTask(RecAreaDao recAreaDao) {
      mRecAreaDao = recAreaDao;
    }

    @Override
    protected Void doInBackground(List<RecreationalArea>... lists) {
      mRecAreaDao.save(lists[0]);
      return null;
    }
  }
}
