package com.example.contacts.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.model.ContactModel
import com.example.contacts.repo.local.ContactDB
import com.example.contacts.repo.local.dao.ContactDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrudViewModel : ViewModel() {
    fun insertInto(context: Context, contactModel: ContactModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val contactDAO: ContactDAO? =
                ContactDB.getDatabase(context)?.contactDao()
            contactDAO?.addContact(contactModel)
        }
    }
    fun update(context: Context, contactModel: ContactModel){
        viewModelScope.launch(Dispatchers.IO){
            val contactDAO:ContactDAO? = ContactDB.getDatabase(context)?.contactDao()
            contactDAO?.updateContact(contactModel)
        }
    }
}
