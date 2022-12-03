package com.example.shoppingitems.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item ORDER BY id ASC")
    fun getShoppingItem() : LiveData<List<ShoppingItem>>
}