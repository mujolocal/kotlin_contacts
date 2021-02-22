package com.example.contacts.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "contact_table")
data class ContactModel(
    val fName:String?,
    val lName:String?,
    val ADDRESS: String?,
    @PrimaryKey
    @NonNull
    val phone: String,
    val email: String?,

    ): Serializable{
    override fun toString(): String {
        return "firstName: $fName, LastName: $lName, Phone: $phone "
    }

    }
