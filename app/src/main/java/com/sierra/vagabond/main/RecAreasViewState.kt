package com.sierra.vagabond.main

import com.sierra.vagabond.data.entities.RecreationalArea

data class RecAreasViewState(val isLoading: Boolean,
                        val error: Error,
                        val areas: List<RecreationalArea>) {

    sealed class Error {
        object NetworkError: Error()
        object None: Error()
    }
}