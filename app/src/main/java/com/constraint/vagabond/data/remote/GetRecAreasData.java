package com.constraint.vagabond.data.remote;

import com.constraint.vagabond.data.RecreationalAreaList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface GetRecAreasData {

  @GET("recareas")
  Call<RecreationalAreaList> getRecreationalAreaData(
      @Query("query") String query, @Query("full") boolean full, @Header("apikey") String apiKey);
}
