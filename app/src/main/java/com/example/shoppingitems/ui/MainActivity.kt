package com.example.shoppingitems.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingitems.R
import com.example.shoppingitems.Room.ShoppingDatabase
import com.example.shoppingitems.Room.ShoppingItem
import com.example.shoppingitems.adapter.ShoppingAdapter
import com.example.shoppingitems.repositary.Respositary

import com.example.shoppingitems.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    
    private lateinit var binding: ActivityMainBinding
//    private  val viewModel: ShoppingViewModel by lazy {
//        ViewModelProvider(this)[ShoppingViewModel::class.java]
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)


        val database = ShoppingDatabase(this)
        val repositary = Respositary(database)
        val factory = MainViewModelFactory(repositary)
        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

       val adapter =ShoppingAdapter(viewModel)
       binding.recyclerView.adapter = adapter
       binding.recyclerView.layoutManager =LinearLayoutManager(this)
       viewModel.getAllShopping().observe(this, Observer{
           adapter.set(it)
       })

       binding.floating.setOnClickListener {
           DailogItem(this,
           object : DalogListener{
               override fun addButtonClicked(item: ShoppingItem) {
                  viewModel.upsert(item)
               }

           }).show()
       }


    setContentView(binding.root)
    }
}