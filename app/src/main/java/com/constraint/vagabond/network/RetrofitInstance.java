package com.constraint.vagabond.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

  private static final String BASE_URL = "https://ridb.recreation.gov/api/v1/";
  private static Retrofit retrofit;

  public static Retrofit getInstance() {

    if (retrofit == null) {
      retrofit =
          new retrofit2.Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .build();
    }

    return retrofit;
  }
}
