package com.sierra.vagabond.main.search

import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.Single

object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(AreasApiService.create())
    }
}

class SearchRepository(private val recAreaData: AreasApiService) {
    fun getRecAreasList(query: String, apiKey: String): Single<RecreationalAreaList> {
        return recAreaData.getRecreationalAreaData(query, full = true, apiKey = apiKey)
    }
}

