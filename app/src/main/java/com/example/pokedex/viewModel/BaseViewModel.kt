package com.example.pokedex.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {
    val error by lazy { MutableLiveData<String>() }
    private val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun doOnError(errorMessage: Throwable){
        error.postValue(errorMessage.message)
        errorMessage.printStackTrace()
    }

    fun addDisposable(disposable: Disposable){
        this.disposable.add(disposable)
    }
}