package com.example.contacts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.contacts.R
import com.example.contacts.databinding.ActivityMainBinding

/**
 * how to go back from one fragment to another
 *
 */

class MainActivity : AppCompatActivity() {
    private val CONTACT_KEY = "contact_key"
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    var listContactsFragment =  ListContactsFragment()
    var crudFragment = CrudFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
//                add(binding.fragmentContainer.id,listContactsFragment)
            }
        }
//        listContactsFragment.toCrud.observe(this){
//            if(it.toCrud and (it.contactModel == null)){
//                supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id,crudFragment ).commit()
//            }else if (it.toCrud and (it.contactModel != null)){
////                supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id,crudFragment ).commit()
//                val bundle = Bundle()
//                bundle.putSerializable(CONTACT_KEY,it.contactModel)
//                crudFragment.arguments = bundle
//                Log.d(TAG, "onCreate: ${it.contactModel}")
//                supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id,crudFragment ).commit()
//            }
        }



//    }
}