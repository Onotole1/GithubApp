package ru.spitchenko.githubapp.component.lifecycle

import androidx.lifecycle.*

interface SingleLiveEvent<T> {

    fun observe(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit)
}

interface SingleLiveEventTarget<T> {

    fun sendEvent(event: T)
}

class MutableSingleLiveEvent<T> : SingleLiveEvent<T>,
    SingleLiveEventTarget<T>,
    LifecycleEventObserver {

    private var observer: ((T) -> Unit)? = null
    private var boundObserver: ((T) -> Unit)? = null

    private var buffer: T? = null

    override fun sendEvent(event: T) {
        val boundObserver = boundObserver

        if (boundObserver != null) {
            boundObserver(event)
        } else {
            buffer = event
        }
    }

    override fun observe(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) {
        this.observer = observer
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> connect()
            Lifecycle.Event.ON_STOP -> disconnect()
            Lifecycle.Event.ON_DESTROY -> destroy(source)
            else -> Unit
        }
    }

    private fun connect() {
        val observer = observer
        if (observer != null) {
            boundObserver = observer

            val buffer = buffer
            if (buffer != null) {
                observer(buffer)
                this.buffer = null
            }
        }
    }

    private fun disconnect() {
        boundObserver = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy(lifecycleOwner: LifecycleOwner) {
        observer = null
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}

fun SingleLiveEventTarget<Unit>.call() {
    sendEvent(Unit)
}