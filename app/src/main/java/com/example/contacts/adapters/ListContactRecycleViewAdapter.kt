package com.example.contacts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.model.ContactModel

class ListContactRecycleViewAdapter(var contacts: ArrayList<ContactModel>): RecyclerView.Adapter<ListContactRecycleViewAdapter.ViewHolder>() {

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
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}