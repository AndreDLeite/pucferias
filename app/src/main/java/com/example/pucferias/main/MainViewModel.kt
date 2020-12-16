package com.example.pucferias.main

import android.app.Application
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.koin.core.KoinComponent

class MainViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    var number = 0

    private val _isNumberOdd = MutableLiveData<NumberState>()
    val isNumberOdd: LiveData<NumberState>
        get() = _isNumberOdd

    fun addNumber() {
        _isNumberOdd.postValue(NumberState.LOADING)
        Handler().postDelayed({
            number++
            if(number % 2 == 0) {
                _isNumberOdd.postValue(NumberState.SUCCESS)
            } else {
                _isNumberOdd.postValue(NumberState.ERROR)
            }
        }, 2000)

    }

    enum class NumberState {
        SUCCESS,
        ERROR,
        LOADING
    }

}