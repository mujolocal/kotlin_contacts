package com.example.contacts.view

import android.net.wifi.hotspot2.pps.Credential
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.contacts.R
import com.example.contacts.databinding.FragmentCrudBinding
import com.example.contacts.model.Address
import com.example.contacts.model.ContactModel
import com.example.contacts.repo.local.ContactDB
import com.example.contacts.repo.local.dao.ContactDAO
import com.example.contacts.viewModel.CrudViewModel
import kotlinx.coroutines.Dispatchers

class CrudFragment: Fragment(R.layout.fragment_crud) {
    private val TAG = "CrudFragment"
    lateinit var binding: FragmentCrudBinding
    lateinit var contactModel: ContactModel
    val crudViewModel = CrudViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrudBinding.inflate(layoutInflater)
        binding.commitBtn.setOnClickListener {
            contactModel = ContactModel(
                binding.crudFnameIv.text.toString(),
                binding.crudLnameIv.text.toString(),
                binding.crudStreetIv.text.toString(),
                binding.crudPhoneIv.text.toString(),
                binding.crudEmailIv.text.toString()
            )
            crudViewModel.insertInto(binding.root.context,contactModel)
            Log.d(TAG, "onCreateView: $contactModel ")

        }


        return binding.root
    }
}