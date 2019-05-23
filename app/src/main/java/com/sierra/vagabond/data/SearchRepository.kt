package com.sierra.vagabond.data

import com.sierra.vagabond.data.entities.PushToken
import com.sierra.vagabond.data.entities.RecreationalAreaList
import com.sierra.vagabond.data.entities.TokenResponse
import com.sierra.vagabond.data.entities.Watch
import com.sierra.vagabond.data.remote.AreasApiService
import com.sierra.vagabond.data.remote.SierraApiService
import io.reactivex.Single
import retrofit2.Call

object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(AreasApiService.create())
    }

    fun provideSierraService(): SierraRepository {
        return SierraRepository(SierraApiService.create())
    }
}

class SearchRepository(private val recAreaData: AreasApiService) {
    fun getRecAreasList(query: String, apiKey: String): Single<RecreationalAreaList> {
        val activity = "CAMPING"
        return recAreaData.getRecreationalAreaData(query, full = true, apiKey = apiKey, activity = activity)
    }
}

class SierraRepository(private val sierraApiService: SierraApiService) {
    fun registerForPush(deviceToken: String?): Call<TokenResponse> {
        val pushToken = PushToken(deviceToken)
        return sierraApiService.registerPushToken(pushToken)
    }

    fun createWatch(watch: Watch): Single<Watch> {
        return sierraApiService.createWatch(watch)
    }
}

