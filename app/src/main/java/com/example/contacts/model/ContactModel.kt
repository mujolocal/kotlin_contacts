package com.example.contacts.model

import java.io.Serializable

data class ContactModel(
    val fName:String,
    val lName:String,
    val ADDRESS: Address,
    val phone: List<String>,
    val email: List<String>,

): Serializable
