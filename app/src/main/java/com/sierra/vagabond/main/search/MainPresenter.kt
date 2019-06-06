package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.SearchRepositoryProvider
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(
        private val view: MainMvp.View, private val areaRepository: RecAreaRepository) : MainMvp.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private val searchRepository = SearchRepositoryProvider.provideSearchRepository()
    private var isDataStored: Boolean = false

    override fun onDestroy() {
        compositeDisposable.dispose()
        clearDb()
    }

    override fun onSearch(query: String, apiKey: String) {
        view.showProgress()
        clearDb()
        compositeDisposable.add(searchRepository
                .getRecAreasList(query, apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable { result ->
                    handleSuccess(result)
                    result.areasList
                }
                .subscribe({ result ->
                    saveToDb(recArea = result)
                    isDataStored = true
                },
                { error -> handleError(error) }))
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

    private fun saveToDb(recArea: RecreationalArea) {
        areaRepository.insert(recArea)
    }

    private fun clearDb() {
        if (isDataStored) {
            Completable.fromAction {
                areaRepository.clearAll()
            }
                    .subscribeOn(Schedulers.single())
                    .subscribe { isDataStored = false }
                    .dispose()

        }
    }
}
