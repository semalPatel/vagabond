package com.sierra.vagabond.viewmodels

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
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

    val isLoading: ObservableBoolean = ObservableBoolean(false)

    fun getRecAreaList(recAreaID: String) {
        viewModelScope.launch {
            isLoading.set(true)
            val response = areaRepository.getRecAreasList(recAreaID).data
                    .filter { area ->
                area.recAreaMediaList.isNotEmpty()
            }
            areaRepository.insertAll(response)
            recAreasResult.value = response.asSequence()
            isLoading.set(false)
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