package com.sierra.vagabond.data.local;

import android.content.Context;

import com.sierra.vagabond.data.entities.RecAreaMedia;
import com.sierra.vagabond.data.entities.RecreationalArea;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(AndroidJUnit4.class)
public class RecAreaDbTest  {

    private RecAreaDao recAreaDao;
    private RecAreaDatabase recAreaDatabase;

    @Before
    public void createDB(){
        Context context = ApplicationProvider.getApplicationContext();
        recAreaDatabase = Room.inMemoryDatabaseBuilder(context, RecAreaDatabase.class).build();
        recAreaDao = recAreaDatabase.recAreaDao();
    }

    @After
    public void closeDB() throws IOException {
        recAreaDatabase.close();
    }

    @Test
    public void saveAndReadAreasTest() throws Exception {
        List<RecAreaMedia> recAreaMediaList = new ArrayList<>();
        List<RecreationalArea> recreationalAreaList = new ArrayList<>();
        RecAreaMedia testRecAreaMedia1 = new RecAreaMedia("Sierra National Forest", 100, 700, "some-jpeg");
        recAreaMediaList.add(testRecAreaMedia1);
        RecreationalArea testRecreationalArea1 = new RecreationalArea("1074",
                                                            "Sierra National Forest",
                                                        "A description",
                                                        "",
                                                            "{}",
                                                            "public_affairs@fs.fed.us",
                                                                        recAreaMediaList);
        recreationalAreaList.add(testRecreationalArea1);
        recAreaDao.save(recreationalAreaList);
        RecreationalArea getTestArea = recAreaDao.getArea("1074");
        assertThat(getTestArea.getRecAreaDescription()).isEqualTo(testRecreationalArea1.getRecAreaDescription());
    }

}
