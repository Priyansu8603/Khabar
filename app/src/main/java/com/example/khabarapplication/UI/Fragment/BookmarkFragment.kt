package com.example.khabarapplication.UI.Fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HeaderViewListAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Insert
import com.example.khabarapplication.Adapter.LatestHeadlineAdapter
import com.example.khabarapplication.R
import com.example.khabarapplication.UI.Activity.HomeScreenActivity
import com.example.khabarapplication.ViewModels.NewsViewModel
import com.example.khabarapplication.databinding.FragmentBookmarkBinding
import java.util.zip.Inflater

class BookmarkFragment : Fragment(R.layout.fragment_bookmark) {

    private lateinit var binding: FragmentBookmarkBinding
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: LatestHeadlineAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)



        newsViewModel = (activity as HomeScreenActivity).newsViewModel

        setUpRecyclerView()

        newsAdapter.setOnItemClickListener {

            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_bookmarkFragment_to_articleFragment,bundle)
        }


        return binding.root
    }

    private fun setUpRecyclerView() {
        newsAdapter = LatestHeadlineAdapter()
        binding.bookmarkRcView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }

}