package com.example.contacts.model

import java.io.Serializable

data class ContactModel(
    val fName:String?,
    val lName:String?,
    val ADDRESS: Address?,
    val phone: String?,
    val email: String?,

    ): Serializable{
    override fun toString(): String {
        return "firstName: $fName, LastName: $lName, Phone: $phone "
    }

    }
