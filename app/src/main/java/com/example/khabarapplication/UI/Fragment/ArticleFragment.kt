package com.example.khabarapplication.UI.Fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.khabarapplication.Adapter.LatestHeadlineAdapter
import com.example.khabarapplication.R
import com.example.khabarapplication.UI.Activity.HomeScreenActivity
import com.example.khabarapplication.ViewModels.NewsViewModel
import com.example.khabarapplication.databinding.FragmentArticleBinding


class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: FragmentArticleBinding
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(inflater, container, false)

        newsViewModel = (activity as HomeScreenActivity).newsViewModel

        val article = args.article
        binding.articleWebView.apply {
            loadUrl(article.url)
        }

        return binding.root
    }

}