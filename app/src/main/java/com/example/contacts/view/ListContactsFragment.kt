package com.example.contacts.view

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.adapters.ListContactRecycleViewAdapter
import com.example.contacts.databinding.FragmentListContactsBinding
import com.example.contacts.model.ContactModel

class ListContactsFragment: Fragment(R.layout.fragment_list_contacts) {
    lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentListContactsBinding
    var contacts = arrayListOf<ContactModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))
        contacts.add(ContactModel("a","bbbbb", null, null,null))




        binding = FragmentListContactsBinding.inflate(layoutInflater)
        recyclerView = binding.listContactRecycleView
        val layoutManager = LinearLayoutManager(binding.root.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val listConstactRecyclerViewAdapter = ListContactRecycleViewAdapter(contacts)
        recyclerView.adapter = listConstactRecyclerViewAdapter
        return binding.root
    }
}