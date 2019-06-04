package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.SearchRepositoryProvider
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPresenter(
        private val view: MainMvp.View) : MainMvp.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private val searchRepository = SearchRepositoryProvider.provideSearchRepository()
    private val areaRepository = RecAreaRepository(view.provideContext())

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onSearch(query: String, apiKey: String) {

        view.showProgress()
        compositeDisposable.add(searchRepository
                .getRecAreasList(query, apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    handleSuccess(result)
                    result.areasList.map { area ->
                        saveToDb(area)
                    }
                },
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

    private fun saveToDb(recArea: RecreationalArea) {
        areaRepository.insert(recArea)
    }
}
