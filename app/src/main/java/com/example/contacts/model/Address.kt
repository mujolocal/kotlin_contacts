package com.example.contacts.model

import java.io.Serializable

data class Address(
    val streetAddress:String,
    val city: String,
    val state: String,
    val zipcode: String,
):Serializable
