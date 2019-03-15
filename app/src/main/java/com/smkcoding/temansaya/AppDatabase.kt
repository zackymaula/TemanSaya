package com.smkcoding.temansaya

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context/*
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase*/

@Database(entities = [MyFriend::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun myFriendDao(): MyFriendDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "MyFriendAppDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}