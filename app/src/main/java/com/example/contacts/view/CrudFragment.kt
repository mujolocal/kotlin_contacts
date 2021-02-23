package com.example.contacts.view

import android.net.wifi.hotspot2.pps.Credential
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
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
    private val CONTACT_KEY = "contact_key"
    lateinit var binding: FragmentCrudBinding
    lateinit var contactModel: ContactModel
    val crudViewModel = CrudViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrudBinding.inflate(layoutInflater)
        (activity as MainActivity).findViewById<Toolbar>(R.id.my_toolbar).title = "Creations school"
        val savedContactModel = null
        if (savedContactModel != null){

            Log.d(TAG, "onCreateView: no null")
//            binding.crudFnameIv.setText( savedContactModel.fName )
//            binding.crudLnameIv.setText(savedContactModel.lName)
//            binding.crudStreetIv.setText(savedContactModel.ADDRESS)
//            binding.crudPhoneIv.setText(savedContactModel.phone)
//            binding.crudEmailIv.setText(savedContactModel.email)
//            binding.commitBtn.text = "Update Contact"

            
        }


        binding.commitBtn.setOnClickListener {
            contactModel = ContactModel(
                binding.crudFnameIv.text.toString(),
                binding.crudLnameIv.text.toString(),
                binding.crudStreetIv.text.toString(),
                binding.crudPhoneIv.text.toString(),
                binding.crudEmailIv.text.toString()
            )
            if (savedContactModel != null){
                crudViewModel.update(binding.root.context,contactModel)
                Log.d(TAG, "onCreateView: updated")
            }else {
                crudViewModel.insertInto(binding.root.context, contactModel)
                Log.d(TAG, "onCreateView: $contactModel ")
                val fm = this.findNavController()
                fm.popBackStack()
            }
        }


        return binding.root
    }
}