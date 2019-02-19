package com.constraint.vagabond.main.details;

public interface DetailsContract {

  interface View {

    void initializeView();

    void initializeData();

    void setDataToRecyclerView();
  }
}
