package com.sierra.vagabond.main.search

import androidx.lifecycle.ViewModel
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.data.entities.RecreationalArea
import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class RecAreasViewModel @Inject constructor(private val areaRepository: RecAreaRepository) : ViewModel() {

    fun getSingleArea(recAreaID: String): Flowable<RecreationalArea> {
        return areaRepository.getSingleArea(recAreaID)
    }
}