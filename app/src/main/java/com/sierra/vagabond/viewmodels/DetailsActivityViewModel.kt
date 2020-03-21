package com.sierra.vagabond.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecAreaFacilities
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.WatchRequest
import com.sierra.vagabond.utils.RC_FACILITIES_ENDPOINT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsActivityViewModel (private val areaRepository: RecAreaRepository) : ViewModel() {

    private val recArea: MutableLiveData<RecreationalArea> = MutableLiveData()
    val area: LiveData<RecreationalArea> = recArea

    private val facilities: MutableLiveData<List<RecAreaFacilities>> = MutableLiveData()
    val areaFacilities: LiveData<List<RecAreaFacilities>> = facilities

    fun getSingleArea(recAreaId: String?) {
        viewModelScope.launch {
            recArea.value = areaRepository.getSingleArea(recAreaId)
            Log.d("areaSingle", areaRepository.getSingleArea(recAreaId).recAreaDescription)
        }
    }

    fun getFacilitiesForArea(recAreaId: String?) {
        viewModelScope.launch {
            val responseFacilities = areaRepository.getFacilitiesForArea(recAreaId).data.filter { facilities ->
                facilities.isReservable
            }
            facilities.value = responseFacilities
        }
    }

    fun createWatch(watch: WatchRequest) {
        viewModelScope.launch {
            areaRepository.createWatch(watch)
        }
    }
}