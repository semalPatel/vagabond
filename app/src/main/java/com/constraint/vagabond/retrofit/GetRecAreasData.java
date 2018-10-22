package com.constraint.vagabond.retrofit;

import com.constraint.vagabond.BuildConfig;
import com.constraint.vagabond.data.RecreationalAreaList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetRecAreasData {


    @GET("recareas")
    Call<RecreationalAreaList> getRecreationalAreaData(@Query("query") String query, @Header("apikey") String apiKey);

}
