package com.constraint.vagabond.main.search

import com.constraint.vagabond.data.entities.RecreationalAreaList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
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
                .subscribeWith(object : DisposableSingleObserver<RecreationalAreaList>() {
                    override fun onSuccess(t: RecreationalAreaList) {
                        mainView?.setDataToRecyclerView(t)
                        mainView?.hideProgress()
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
