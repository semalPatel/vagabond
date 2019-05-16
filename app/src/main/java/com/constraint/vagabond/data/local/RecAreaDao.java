package com.constraint.vagabond.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.constraint.vagabond.data.entities.RecreationalArea;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface RecAreaDao {

  @Insert(onConflict = REPLACE)
  void save(List<RecreationalArea> recreationalAreaList);

  @Query("SELECT * FROM recreationalarea")
  List<RecreationalArea> getAreas();

  @Query("SELECT * FROM recreationalarea WHERE recAreaID = :rec_area_id")
  RecreationalArea getArea(String rec_area_id);
}
