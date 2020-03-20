package com.sierra.vagabond.viewmodels

open class Event<out T> (private val content: T) {

    var hasBeenHandled: Boolean = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}