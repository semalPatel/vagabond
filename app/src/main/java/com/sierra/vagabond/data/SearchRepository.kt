package com.sierra.vagabond.data

import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.data.entities.WatchResponse
import com.sierra.vagabond.data.remote.AreasApiService
import com.sierra.vagabond.data.remote.SierraApiService
import com.sierra.vagabond.utils.CAMPING
import io.reactivex.Observable
import io.reactivex.Single

object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(AreasApiService.create())
    }

    fun provideSierraService(): SierraRepository {
        return SierraRepository(SierraApiService.create())
    }
}

class SearchRepository(private val recAreaData: AreasApiService) {
    fun getRecAreasList(query: String, apiKey: String): Observable<RecreationalAreaList> {
        return recAreaData.getRecreationalAreaData(query, full = true, apiKey = apiKey, activity = CAMPING)
    }
}

class SierraRepository(private val sierraApiService: SierraApiService) {

    fun createWatch(watch: WatchRequest): Single<WatchResponse> {
        return sierraApiService.createWatch(watch)
    }
}

