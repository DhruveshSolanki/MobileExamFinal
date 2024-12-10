package com.dhruvesh.solanki.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhruvesh.solanki.Model.StockInfo
import kotlinx.coroutines.launch

class StockViewModel(private val repository: StockRepository): ViewModel() {

    var dbStockInfo by mutableStateOf<List<StockInfo>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val stockInfoFromDB = repository.getAllStocks()
            dbStockInfo = stockInfoFromDB
        }
    }

    // Fetch all stocks from the database
     fun fetchAllStocks() {
        viewModelScope.launch {
            val stocks = repository.getAllStocks()
            dbStockInfo = stocks
        }
    }

    // Insert a stock
    fun insertStock(stockInfo: StockInfo) {
        viewModelScope.launch {
            repository.insertStock(stockInfo)
            fetchAllStocks() // Refresh list after insertion
        }
    }

    // Update a stock
    fun updateStock(stockInfo: StockInfo) {
        viewModelScope.launch {
            repository.updateStock(stockInfo)
            fetchAllStocks() // Refresh list after update
        }
    }

    // Delete a stock
    fun deleteStock(stockInfo: StockInfo) {
        viewModelScope.launch {
            repository.deleteStock(stockInfo)
            fetchAllStocks() // Refresh list after deletion
        }
    }
}