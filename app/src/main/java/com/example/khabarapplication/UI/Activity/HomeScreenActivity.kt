package com.example.khabarapplication.UI.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.khabarapplication.Database.ArticleDatabase
import com.example.khabarapplication.R
import com.example.khabarapplication.Repository.NewsRepository
import com.example.khabarapplication.ViewModels.NewsViewModel
import com.example.khabarapplication.ViewModels.NewsViewModelProviderFactory
import com.example.khabarapplication.databinding.ActivityHomescreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var navController:NavController
    lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: ActivityHomescreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_home -> navController.navigate(R.id.homeFragment)
                R.id.bottom_explore -> navController.navigate(R.id.exploreFragment)
                R.id.bottom_bookmark -> navController.navigate(R.id.bookmarkFragment)
                R.id.bottom_user -> navController.navigate(R.id.profileFragment)
            }
            true
        }


    }


}


