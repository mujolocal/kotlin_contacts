package com.example.contacts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.contacts.R
import com.example.contacts.databinding.ActivityMainBinding

/**
 * how to go back from one fragment to another
 *
 */

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var listContactsFragment =  ListContactsFragment()
    var crudFragment = CrudFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtview.text = "the binding is complete"

        if(savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(binding.fragmentContainer.id,listContactsFragment)
            }
        }
        listContactsFragment.toCrud.observe(this){
            if(it){
                supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id,crudFragment ).commit()
            }
        }


    }
}