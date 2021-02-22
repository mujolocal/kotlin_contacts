package com.example.contacts.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contacts.model.ContactModel
import com.example.contacts.repo.local.dao.ContactDAO
import kotlinx.coroutines.*

@Database(entities = [ContactModel::class], version = 1)
abstract class ContactDB : RoomDatabase() {
    abstract fun contactDao():ContactDAO

    companion object{
        private const val DBNAME:String = "ContactDb.db"
        private var INSTANCE: ContactDB? = null

        fun getDatabase(context: Context): ContactDB?{
            if (INSTANCE == null){
                synchronized(ContactDB::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    ContactDB::class.java, DBNAME).build()
                }
            }
            return INSTANCE

        }


    }

}