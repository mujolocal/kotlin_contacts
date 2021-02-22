package com.example.contacts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.contacts.R
import com.example.contacts.databinding.FragmentCrudBinding

class CrudFragment: Fragment(R.layout.fragment_crud) {
    lateinit var binding: FragmentCrudBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrudBinding.inflate(layoutInflater)

        return binding.root
    }
}