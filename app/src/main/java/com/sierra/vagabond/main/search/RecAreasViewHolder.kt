package com.sierra.vagabond.main.search

import androidx.lifecycle.ViewModel
import com.sierra.vagabond.data.RecAreaRepository
import javax.inject.Inject

class RecAreasViewHolder @Inject constructor(areaRepository: RecAreaRepository) : ViewModel() {


    override fun onCleared() {
        super.onCleared()

    }
}