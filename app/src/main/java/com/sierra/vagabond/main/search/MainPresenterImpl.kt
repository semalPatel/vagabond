package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.SearchRepositoryProvider
import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainPresenterImpl(
        private val view: MainMvp.View) : MainMvp.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onSearch(query: String, apiKey: String) {
        view.showProgress()
        val repository = SearchRepositoryProvider.provideSearchRepository()
        compositeDisposable.add(repository
                .getRecAreasList(query, apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> handleSuccess(result) },
                        { error -> handleError(error) })
        )
    }

    private fun handleSuccess(result: RecreationalAreaList) {
        view.hideProgress()
        if (result.areasList.isEmpty()) {
            view.onResponseFailure()
        } else {
            view.setDataToRecyclerView(result)
        }
    }

    private fun handleError(error: Throwable) {
        view.hideProgress()
        view.onResponseFailure()
        error.stackTrace
    }

}
