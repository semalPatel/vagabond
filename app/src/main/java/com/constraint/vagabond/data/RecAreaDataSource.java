package com.constraint.vagabond.data;

import java.util.List;

public interface RecAreaDataSource {

    void save(List<RecreationalArea> recreationalAreaList);

    List<RecreationalArea> getAreas();

    RecreationalArea getArea(String rec_area_id);
}
