package com.dhruvesh.solanki.ViewModel

import com.dhruvesh.solanki.Model.StockInfo
import com.dhruvesh.solanki.Model.StockInfoDAO

class StockRepository(private val stockInfoDAO: StockInfoDAO) {

    // Insert a stock
    suspend fun insertStock(stockInfo: StockInfo) {
        stockInfoDAO.insertStockInfo(stockInfo)
    }

    // Update a stock
    suspend fun updateStock(stockInfo: StockInfo) {
        stockInfoDAO.updateStockInfo(stockInfo)
    }

    // Delete a stock
    suspend fun deleteStock(stockInfo: StockInfo) {
        stockInfoDAO.deleteStockInfo(stockInfo)
    }

    // Get all stocks
    suspend fun getAllStocks(): List<StockInfo> {
        return stockInfoDAO.getAllStockInfo()
    }
}