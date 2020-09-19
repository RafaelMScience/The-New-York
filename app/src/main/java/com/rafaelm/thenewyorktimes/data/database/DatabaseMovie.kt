package com.rafaelm.thenewyorktimes.data.database

import android.content.Context
import androidx.room.Room

abstract class DatabaseMovie{

//    abstract val databaseChat: DAOChat
//
//    companion object{
//        @Volatile
//        private var INSTANCE: DatabaseChat? = null
//
//        fun getInstance(context: Context): DatabaseChat{
//            synchronized(this){
//                var instance = INSTANCE
//
//                if(instance == null){
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        DatabaseChat::class.java,
//                        "chat_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//
//                return instance
//            }
//        }

//    }
}