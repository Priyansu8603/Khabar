package com.example.khabarapplication.UI.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.khabarapplication.R
import com.example.khabarapplication.UI.Fragment.BookmarkFragment
import com.example.khabarapplication.UI.Fragment.ExploreFragment
import com.example.khabarapplication.UI.Fragment.HomeFragment
import com.example.khabarapplication.UI.Fragment.ProfileFragment
import com.example.khabarapplication.databinding.ActivityHomescreenBinding

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    private lateinit var binding: ActivityHomescreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment((HomeFragment()))
                R.id.bottom_explore -> openFragment(ExploreFragment())
                R.id.bottom_bookmark -> openFragment(BookmarkFragment())
                R.id.bottom_user -> openFragment(ProfileFragment())
            }
            true
        }
        fragmentManager= supportFragmentManager
        openFragment(HomeFragment())



    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment )
        fragmentTransaction.commit()


    }

}


