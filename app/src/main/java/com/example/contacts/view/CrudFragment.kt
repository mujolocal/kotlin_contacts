package com.example.contacts.view

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

class CrudFragment: Fragment(R.layout.fragment_crud) {
    private val TAG = "CrudFragment"
    lateinit var binding: FragmentCrudBinding
    lateinit var contactModel: ContactModel
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
                Address(
                    binding.crudStreetIv.text.toString(),
                    binding.crudCityIv.text.toString(),
                    binding.crudStateIv.text.toString(),
                    binding.crudZipIv.text.toString()
                ),
                binding.crudPhoneIv.text.toString(),
                binding.crudEmailIv.text.toString()
            )
            Log.d(TAG, "onCreateView: $contactModel ")
        }


        return binding.root
    }
}