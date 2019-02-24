package com.constraint.vagabond.data;

import android.app.Application;
import android.os.AsyncTask;

import com.constraint.vagabond.data.local.RecAreaDao;
import com.constraint.vagabond.data.local.RecAreaDatabase;

import java.util.List;


public class RecAreaRepository {

    private RecAreaDao recAreaDao;
    private List<RecreationalArea> recreationalAreas;
    private RecreationalArea singleArea;

    public RecAreaRepository(Application application){
        RecAreaDatabase db = RecAreaDatabase.getInstance(application);
        recAreaDao = db.recAreaDao();
        recreationalAreas = recAreaDao.getAreas();
    }

    public RecreationalArea getSingleArea(String recAreaId){
        return recAreaDao.getArea(recAreaId);
    }

    public void saveAreas(List<RecreationalArea> recreationalAreas){
        new asyncInsertTask(recAreaDao).execute(recreationalAreas);
    }

    private static class asyncInsertTask extends AsyncTask<List<RecreationalArea>, Void, Void>{
        private RecAreaDao mRecAreaDao;

        asyncInsertTask(RecAreaDao recAreaDao){
            mRecAreaDao = recAreaDao;
        }

        @Override
        protected Void doInBackground(List<RecreationalArea>... lists) {
            mRecAreaDao.save(lists[0]);
            return null;
        }
    }
}
