package com.example.khabarapplication.UI.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khabarapplication.Adapter.LatestHeadlineAdapter
import com.example.khabarapplication.R
import com.example.khabarapplication.UI.Activity.HomeScreenActivity
import com.example.khabarapplication.Utils.Resource
import com.example.khabarapplication.ViewModels.NewsViewModel
import com.example.khabarapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var navController: NavController
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: LatestHeadlineAdapter
    private lateinit var binding: FragmentHomeBinding

    val TAG  = "Breaking News Fragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        newsViewModel = (activity as HomeScreenActivity).newsViewModel

        setUpRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply{
                putSerializable("article",it)

            }
            findNavController().navigate(
                R.id.action_homeFragment_to_articleFragment,bundle
            )

        }


        newsViewModel.headlines.observe(viewLifecycleOwner, Observer {response->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {newsResponse->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    response.message?.let {message->
                        Log.e(TAG,"An Error occurred: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })

        binding.searchEditTxt.setOnClickListener {
            // Use Navigation Component to navigate to the SearchFragment
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }





        return binding.root
    }





    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setUpRecyclerView() {
        newsAdapter = LatestHeadlineAdapter()
        binding.LatestRcView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }


}

