package com.constraint.vagabond.data;

import android.util.Log;

import com.constraint.vagabond.BuildConfig;
import com.constraint.vagabond.main.MainContract;
import com.constraint.vagabond.network.RetrofitInstance;
import com.constraint.vagabond.retrofit.GetRecAreasData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetRecAreasImpl implements MainContract.GetRecAreasInteractor {

  String apiKey = "sss";

  @Override
  public void getRecAreasList(final OnFinishedListener onFinishedListener, String query) {
    GetRecAreasData service = RetrofitInstance.getInstance().create(GetRecAreasData.class);
    Call<RecreationalAreaList> call = service.getRecreationalAreaData(query, apiKey);
    Log.d("URL called", call.request().url() + "");
    call.enqueue(
        new Callback<RecreationalAreaList>() {
          @Override
          public void onResponse(
              Call<RecreationalAreaList> call, Response<RecreationalAreaList> response) {
            onFinishedListener.onFinished(response.body().getRecreationalAreaList());
          }
          @Override
          public void onFailure(Call<RecreationalAreaList> call, Throwable t) {
            onFinishedListener.onFailure(t);
          }
        });
  }
}
