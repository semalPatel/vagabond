package com.sierra.vagabond.main.search

import com.sierra.vagabond.VagabondApplication
import com.sierra.vagabond.api.AreasApiService
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.SearchRepositoryProvider
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.di.AppComponent
import com.sierra.vagabond.di.AppInjector
import com.sierra.vagabond.di.AppModule
import com.sierra.vagabond.di.DaggerAppComponent
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.reflect.Constructor
import javax.inject.Inject

class MainPresenter @Inject constructor (private val view: MainMvp.View, private val searchRepositoryProvider: SearchRepositoryProvider) : MainMvp.Presenter {

//    @Inject lateinit var searchRepositoryProvider: SearchRepositoryProvider

    private val compositeDisposable = CompositeDisposable()
    private var isDataStored: Boolean = false

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onSearch(query: String) {
        view.showProgress()
        compositeDisposable.add(searchRepositoryProvider
                .getRecAreasList(query)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable { result ->
                    handleSuccess(result)
                    result.areasList
                }
                .subscribe({ result ->
//                    saveToDb(recArea = result)
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

    /*private fun saveToDb(recArea: RecreationalArea) {
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
    }*/
}
