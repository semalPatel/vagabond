package com.sierra.vagabond.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sierra.vagabond.data.RecAreaRepository
import com.sierra.vagabond.utils.EXCEPTION_STRING_VIEWMODEL
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(private val areaRepository: RecAreaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(areaRepository = areaRepository) as T
        }
        throw IllegalArgumentException(EXCEPTION_STRING_VIEWMODEL)
    }
}