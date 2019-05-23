package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.SearchRepositoryProvider
import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainPresenterImpl(
        private val mainView: MainContract.MainView) : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onSearch(query: String, apiKey: String) {
        mainView.showProgress()
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
        mainView.hideProgress()
        if (result.areasList.isEmpty()) {
            mainView.onResponseFailure()
        } else {
            mainView.setDataToRecyclerView(result)
        }
    }

    private fun handleError(error: Throwable) {
        mainView.hideProgress()
        mainView.onResponseFailure()
        error.stackTrace
    }

}
