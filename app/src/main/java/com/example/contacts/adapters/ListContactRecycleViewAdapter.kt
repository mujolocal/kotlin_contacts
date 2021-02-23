package com.example.contacts.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.model.ContactModel
import com.example.contacts.model.PagePackage
import com.example.contacts.view.ListContactsFragment
import com.example.contacts.view.ListContactsFragmentDirections
import com.example.contacts.viewModel.ListContactsViewModel

class ListContactRecycleViewAdapter(var contacts: List<ContactModel>, val listContactsFragment: ListContactsFragment): RecyclerView.Adapter<ListContactRecycleViewAdapter.ViewHolder>() {
    private  val TAG = "ListContactRecycleViewA"
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fName: TextView
        val lName: TextView

        init {
            fName = view.findViewById(R.id.recycle_view_f_name)
            lName = view.findViewById(R.id.recycle_view_l_name)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycle_view_list_contant_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.lName.text = contacts[position].lName
        holder.fName.text = contacts[position].fName
        holder.itemView.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ${contacts[position]} ")
//            listContactsFragment._toCrud.postValue(PagePackage(true, contacts[position]))
            val action = ListContactsFragmentDirections.actionListContactsFragmentToCrudFragment(contacts[position])
            it.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}