package com.example.shoppingitems.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingitems.R
import com.example.shoppingitems.Room.ShoppingItem
import com.example.shoppingitems.databinding.ShoppingItemBinding
import com.example.shoppingitems.ui.ShoppingViewModel

class ShoppingAdapter( private val viewModel: ShoppingViewModel) : RecyclerView.Adapter<ShoppingAdapter.MyViewHolder>() {

    private var shoppingItem  = emptyList<ShoppingItem>()
    @SuppressLint("NotifyDataSetChanged")
    fun set(item : List<ShoppingItem>){

        this.shoppingItem = item
        notifyDataSetChanged()

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val shopItem =shoppingItem[position]

         holder.bind(shopItem)
        holder.itemClick(shopItem,viewModel)
    }

    override fun getItemCount(): Int {
        return shoppingItem.size
    }

    class MyViewHolder(private val binding: ShoppingItemBinding) : RecyclerView.ViewHolder(binding.root){
        companion object{

            fun from(parent: ViewGroup) : MyViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ShoppingItemBinding.inflate(inflater,parent,false)
                return MyViewHolder(binding)

            }

        }

        fun bind(shoppingItem: ShoppingItem){
            binding.textView.text = shoppingItem.name
            binding.textView2.text = shoppingItem.amount.toString()

        }

        fun itemClick(shopItem: ShoppingItem,viewModel: ShoppingViewModel) {
            binding.add.setOnClickListener {
                shopItem.amount++
                viewModel.upsert(shopItem)
            }

            binding.minus.setOnClickListener {
                if (shopItem.amount>0){
                    shopItem.amount--
                    viewModel.upsert(shopItem)
                }

            }
            binding.delete.setOnClickListener {
                viewModel.delete(shopItem)
            }


        }


    }
}