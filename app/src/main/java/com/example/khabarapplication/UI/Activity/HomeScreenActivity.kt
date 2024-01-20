package com.example.khabarapplication.UI.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.khabarapplication.Database.ArticleDatabase
import com.example.khabarapplication.R
import com.example.khabarapplication.Repository.NewsRepository
import com.example.khabarapplication.UI.Fragment.BookmarkFragment
import com.example.khabarapplication.UI.Fragment.ExploreFragment
import com.example.khabarapplication.UI.Fragment.HomeFragment
import com.example.khabarapplication.UI.Fragment.ProfileFragment
import com.example.khabarapplication.ViewModels.NewsViewModel
import com.example.khabarapplication.ViewModels.NewsViewModelProviderFactory
import com.example.khabarapplication.databinding.ActivityHomescreenBinding

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager
    lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: ActivityHomescreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)



        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)



//        binding.bottomNavigationView.setOnItemSelectedListener { item ->
//            when(item.itemId){
//                R.id.bottom_home -> openFragment((HomeFragment()))
//                R.id.bottom_explore -> openFragment(ExploreFragment())
//                R.id.bottom_bookmark -> openFragment(BookmarkFragment())
//                R.id.bottom_user -> openFragment(ProfileFragment())
//            }
//            true
//        }
//        fragmentManager= supportFragmentManager
//        openFragment(HomeFragment())



    }

//    private fun openFragment(fragment: Fragment){
//        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragmentContainerView, fragment )
//        fragmentTransaction.commit()
//
//
//    }

}


