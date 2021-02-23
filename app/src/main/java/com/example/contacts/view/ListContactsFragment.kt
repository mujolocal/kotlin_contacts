package com.example.contacts.view

import android.os.Binder
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.adapters.ListContactRecycleViewAdapter
import com.example.contacts.databinding.FragmentListContactsBinding
import com.example.contacts.model.ContactModel
import com.example.contacts.model.PagePackage
import com.example.contacts.viewModel.ListContactsViewModel

class ListContactsFragment: Fragment(R.layout.fragment_list_contacts) {
    lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentListContactsBinding
    var contacts = listOf<ContactModel>()
    val listContactsViewModel = ListContactsViewModel()
    val _toCrud = MutableLiveData<PagePackage>()
    val toCrud : LiveData<PagePackage>
        get() = _toCrud

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListContactsBinding.inflate(layoutInflater)

         listContactsViewModel.contactModels.observe(viewLifecycleOwner){
            contacts = it
             setupRecycler()
        }
        listContactsViewModel.getList(binding.root.context)
        (activity as MainActivity).findViewById<Toolbar>(R.id.my_toolbar).title = "running wild"

        binding.btnAddContat.setOnClickListener {
//            _toCrud.value = PagePackage(true,null)
            val action = ListContactsFragmentDirections.actionListContactsFragmentToCrudFragment()
            this.findNavController().navigate(action)
        }


        return binding.root
    }


    fun setupRecycler(){
        recyclerView = binding.listContactRecycleView
        val layoutManager = LinearLayoutManager(binding.root.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val listConstactRecyclerViewAdapter = ListContactRecycleViewAdapter(contacts, this)
        recyclerView.adapter = listConstactRecyclerViewAdapter
    }

}