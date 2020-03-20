package com.sierra.vagabond.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.TokenRequest
import com.sierra.vagabond.data.resource.Resource
import com.sierra.vagabond.main.RecAreasViewState
import com.sierra.vagabond.utils.Prefs
import kotlinx.coroutines.launch

class MainActivityViewModel (private val areaRepository: RecAreaRepository) : ViewModel() {

    private val recAreasResult: MutableLiveData<Sequence<RecreationalArea>> = MutableLiveData()
    val areaList: LiveData<Sequence<RecreationalArea>> = recAreasResult

    fun getRecAreaList(recAreaID: String) {
        viewModelScope.launch {
            val response = areaRepository.getRecAreasList(recAreaID).data
                    .filter { area ->
                area.recAreaMediaList.isNotEmpty()
            }
            areaRepository.insertAll(response)
            response.forEach {
                Log.d("ForEach", it.recAreaName + " repo " + areaRepository.getSingleArea(it.recAreaID).recAreaName)
            }
            /*.filter { recreationalArea ->
                recreationalArea.recAreaFacilities.isNotEmpty()
            }.filter { recreationalArea ->
                        recreationalArea.recAreaMediaList.isNotEmpty()
            }.map { area ->
                launch {
                    areaRepository.insert(area)
                }
                return@map area
            }*/
            recAreasResult.value = response.asSequence()
        }
    }

    fun registerToken() {
        val tokenRequest = TokenRequest(
                userId = "semal",
                fcmToken = Prefs.deviceRegistrationToken
        )
        viewModelScope.launch {
            areaRepository.registerToken(tokenRequest)
        }
    }
}