package com.dhruvesh.solanki.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StockInfoDAO {

    @Query("select * from stock_info")
    suspend fun getAllStockInfo(): List<StockInfo>

    @Insert
    suspend fun insertStockInfo(s: StockInfo);

    @Update
    suspend fun updateStockInfo(s: StockInfo)

    @Delete
    suspend fun deleteStockInfo(s: StockInfo);
}