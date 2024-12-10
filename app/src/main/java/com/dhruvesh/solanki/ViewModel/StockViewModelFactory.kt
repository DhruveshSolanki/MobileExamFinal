package com.dhruvesh.solanki.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StockViewModelFactory(private val repository: StockRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StockViewModel::class.java)){
            return StockViewModel(repository) as T
        }else {
            throw IllegalArgumentException("Error")
        }
    }
}