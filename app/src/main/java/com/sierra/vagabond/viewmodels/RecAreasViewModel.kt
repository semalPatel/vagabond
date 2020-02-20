package com.sierra.vagabond.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import kotlinx.coroutines.launch

class RecAreasViewModel (private val areaRepository: RecAreaRepository) : ViewModel() {

    private val recAreasResult: MutableLiveData<List<RecreationalArea>> = MutableLiveData()
    val areaList: LiveData<List<RecreationalArea>> = recAreasResult

    fun getRecAreaList(recAreaID: String) {
        viewModelScope.launch {
            val response = areaRepository.getRecAreasList(recAreaID)
            val filterResponse = response.filter { recreationalArea ->
                recreationalArea.recAreaFacilities.isNotEmpty()
                recreationalArea.recAreaMediaList.isNotEmpty()
            }
            recAreasResult.value = filterResponse
        }
    }
}