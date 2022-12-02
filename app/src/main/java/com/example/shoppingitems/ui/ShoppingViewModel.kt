package com.example.shoppingitems.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingitems.Room.ShoppingItem
import com.example.shoppingitems.repositary.Respositary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository : Respositary) : ViewModel() {





    fun upsert(item: ShoppingItem) =viewModelScope.launch{
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = viewModelScope.launch {
        repository.delete(item)
    }

    fun getAllShopping() = repository.getShoppingdata()




}