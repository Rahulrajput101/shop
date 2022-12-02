package com.example.shoppingitems.repositary

import androidx.lifecycle.LiveData
import com.example.shoppingitems.Room.ShoppingDao
import com.example.shoppingitems.Room.ShoppingDatabase
import com.example.shoppingitems.Room.ShoppingItem

class Respositary(
    //private val dao: ShoppingDao ,
    private val db: ShoppingDatabase) {


//    suspend fun upsert(shoppingItem: ShoppingItem){
//        dao.upsert(shoppingItem)
//    }
   suspend fun upsert( item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

     fun getShoppingdata() = db.getShoppingDao().getShoppingItem()
}