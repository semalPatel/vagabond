package com.sierra.vagabond.data.resource

import com.sierra.vagabond.data.resource.Status.SUCCESS
import com.sierra.vagabond.data.resource.Status.ERROR
import com.sierra.vagabond.data.resource.Status.LOADING

data class Resource<out T> (val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }

        fun <T> error(data: T?, message: String?): Resource<T> {
            return Resource(ERROR, data, message)
        }
    }
}