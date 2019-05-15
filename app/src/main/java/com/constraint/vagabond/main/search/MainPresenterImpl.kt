package com.constraint.vagabond.main.search

import android.util.Log

import com.constraint.vagabond.data.entities.RecreationalAreaList

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(
        private var mainView: MainContract.MainView?) : MainContract.presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.dispose()
        mainView = null
    }

    override fun onSearch(s: String, apiKey: String) {
        if (mainView != null) {
                mainView!!.showProgress()
        }
        val repository = SearchRepositoryProvider.provideSearchRepository()
        compositeDisposable.add(repository
                .getRecAreasList(s, apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : DisposableObserver<RecreationalAreaList>(){
                    override fun onComplete() {
                        mainView?.hideProgress()
                    }

                    override fun onNext(t: RecreationalAreaList) {
                        mainView?.setDataToRecyclerView(t)
                    }

                    override fun onError(e: Throwable) {
                        mainView?.onResponseFailure()
                        mainView?.hideProgress()
                        e.stackTrace
                    }
                })
        )
    }
}
