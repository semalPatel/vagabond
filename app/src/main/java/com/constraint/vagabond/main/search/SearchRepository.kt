package com.constraint.vagabond.main.search

import com.constraint.vagabond.data.entities.RecreationalAreaList

import io.reactivex.Observable

object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(GetRecAreasData.create())
    }
}

class SearchRepository(val recAreaData: GetRecAreasData) {
    fun getRecAreasList(query: String, apiKey: String) : Observable<RecreationalAreaList> {
        return recAreaData.getRecreationalAreaData(query, full = true, apiKey = apiKey)
    }
}

