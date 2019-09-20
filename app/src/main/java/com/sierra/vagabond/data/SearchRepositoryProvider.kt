package com.sierra.vagabond.data

import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.data.entities.WatchResponse
import com.sierra.vagabond.api.AreasApiService
import com.sierra.vagabond.api.SierraApiService
import com.sierra.vagabond.utils.CAMPING
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryProvider @Inject constructor(private val areasApiService: AreasApiService) {

    /*
    fun provideSearchRepository(query: String): SearchRepository {
        return SearchRepository(AreasApiService.create())
    }*/

    fun getRecAreasList(query: String): Observable<RecreationalAreaList> {
        return areasApiService.getRecreationalAreaData(query, full = true, activity = CAMPING)
    }

    fun provideSierraService(): SierraRepository {
        return SierraRepository(SierraApiService.create())
    }
}

class SearchRepository() {

}

class SierraRepository(private val sierraApiService: SierraApiService) {

    fun createWatch(watch: WatchRequest): Single<WatchResponse> {
        return sierraApiService.createWatch(watch)
    }
}

