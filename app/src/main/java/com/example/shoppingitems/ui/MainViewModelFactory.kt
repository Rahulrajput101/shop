package com.example.shoppingitems.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingitems.repositary.Respositary

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repositary : Respositary):
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repositary) as T
    }

}