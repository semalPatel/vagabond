package com.sierra.vagabond.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.WatchRequest
import kotlinx.coroutines.launch

class DetailsActivityViewModel (private val areaRepository: RecAreaRepository) : ViewModel() {

    private val recArea: MutableLiveData<RecreationalArea> = MutableLiveData()
    val area: LiveData<RecreationalArea> = recArea

    fun getSingleArea(recAreaId: String?) {
        viewModelScope.launch {
            recArea.value = areaRepository.getSingleArea(recAreaId)
            Log.d("areaSingle", areaRepository.getSingleArea(recAreaId).recAreaDescription)
        }
    }

    fun createWatch(watch: WatchRequest) {
        viewModelScope.launch {
            areaRepository.createWatch(watch)
        }
    }
}