package com.sierra.vagabond.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class RecAreasViewModel (private val areaRepository: RecAreaRepository) : ViewModel() {

    private val recAreasResult: MutableLiveData<RecreationalAreaList> = MutableLiveData()
    val areaList: LiveData<RecreationalAreaList> = recAreasResult

    fun getRecAreaList(recAreaID: String) {
        viewModelScope.launch {
            recAreasResult.value = areaRepository.getRecAreasList(recAreaID)
        }
    }
}