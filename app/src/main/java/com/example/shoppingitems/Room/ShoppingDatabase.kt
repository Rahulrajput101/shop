package com.example.shoppingitems.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
 entities = [ShoppingItem::class],
 version = 1
)

abstract class ShoppingDatabase :RoomDatabase() {

    abstract fun getShoppingDao() : ShoppingDao

    companion object{
         @Volatile
         private var Instance :  ShoppingDatabase? = null
        private val LOCK = Any()

        @OptIn(InternalCoroutinesApi::class)
        operator fun invoke(context: Context) = Instance?: synchronized(LOCK){
            Instance?: createDatabase(context).also { Instance =it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java, "ShoppingDB.db").build()


//         @OptIn(InternalCoroutinesApi::class)
//        fun getDatabase(context : Context) : ShoppingDatabase{
//            val tempInstance = Instance
//            if(tempInstance!=null){
//                return tempInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ShoppingDatabase::class.java,
//                    "shopping_database"
//                ).build()
//                Instance = instance
//                return instance
//            }
//
//        }


    }


}