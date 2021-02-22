package com.example.contacts.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.model.ContactModel
import com.example.contacts.repo.local.ContactDB
import com.example.contacts.repo.local.dao.ContactDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ListContactsViewModel: ViewModel() {

    val _contactModels = MutableLiveData<List<ContactModel>>()

    val contactModels : MutableLiveData<List<ContactModel>>
        get() = _contactModels

    fun getList(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            val contactDao = ContactDB.getDatabase(context)?.contactDao()
            contactModels.postValue( contactDao?.getContacts())
        }
    }


}