package com.example.shoppingitems.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingitems.R
import com.example.shoppingitems.Room.ShoppingItem
import com.example.shoppingitems.databinding.DialogListBinding

class DailogItem(context: Context, var addDalogListener: DalogListener) : AppCompatDialog(context) {

    private lateinit var binding : DialogListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =DialogListBinding.inflate(layoutInflater)


        binding.addtxt.setOnClickListener {
            val name =binding.itemName.toString()
            val amount = binding.etamount.toString()
            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all the fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name, amount.toInt())
            addDalogListener.addButtonClicked(item)
            dismiss()

        }
        binding.canceltxt.setOnClickListener {
            cancel()
        }
        setContentView(binding.root)


    }

}