package com.sierra.vagabond.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.TokenRequest
import com.sierra.vagabond.utils.Prefs
import kotlinx.coroutines.launch

class MainActivityViewModel (private val areaRepository: RecAreaRepository) : ViewModel() {

    private val recAreasResult: MutableLiveData<Sequence<RecreationalArea>> = MutableLiveData()
    val areaList: LiveData<Sequence<RecreationalArea>> = recAreasResult

    fun getRecAreaList(recAreaID: String) {
        viewModelScope.launch {
            val response = areaRepository.getRecAreasList(recAreaID)
            val filterResponse = response.asSequence().filter { recreationalArea ->
                recreationalArea.recAreaFacilities.isNotEmpty()
            }.filter { recreationalArea ->
                        recreationalArea.recAreaMediaList.isNotEmpty()
            }.map { area ->
                launch {
                    areaRepository.insert(area)
                }
                return@map area
            }
            recAreasResult.value = filterResponse
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