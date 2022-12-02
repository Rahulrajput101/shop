package com.example.shoppingitems.ui

import com.example.shoppingitems.Room.ShoppingItem

interface DalogListener {
    fun addButtonClicked(item : ShoppingItem)
}