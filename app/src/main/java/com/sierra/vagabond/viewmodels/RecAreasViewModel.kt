package com.sierra.vagabond.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalAreaList
import kotlinx.coroutines.launch

class RecAreasViewModel (private val areaRepository: RecAreaRepository) : ViewModel() {

    private val recAreasResult: MutableLiveData<RecreationalAreaList> = MutableLiveData()
    val areaList: LiveData<RecreationalAreaList> = recAreasResult

    fun getRecAreaList(recAreaID: String) {
        viewModelScope.launch {
            recAreasResult.value = areaRepository.getRecAreasList(recAreaID).also {
                it.areasList.map {
                    recreationalArea -> areaRepository.insert(recreationalArea)
                }
            }
        }
    }
}