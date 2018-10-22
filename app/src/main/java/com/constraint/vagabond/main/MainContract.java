package com.constraint.vagabond.main;

import com.constraint.vagabond.data.RecreationalArea;

import java.util.ArrayList;
import java.util.List;

public interface MainContract {

    interface presenter{

        void onDestroy();

        void onSearch(String query);


    }

    interface MainView{

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<RecreationalArea> recAreasList);

        void onResponseFailure(Throwable throwable);
    }

    interface GetRecAreasInteractor{

        interface OnFinishedListener{

            void onFinished(List<RecreationalArea> recAreasList);
            void onFailure(Throwable t);
        }

        void getRecAreasList(OnFinishedListener onFinishedListener, String query);

    }
}
