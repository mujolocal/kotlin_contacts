package com.example.contacts.repo.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contacts.model.ContactModel

@Dao
interface ContactDAO {
    @Query("SELECT * FROM contact_table")
    fun getContacts() : List<ContactModel>

    @Insert
    fun addContact(contact:ContactModel)

    @Update
    fun updateContact(cotact:ContactModel)
}