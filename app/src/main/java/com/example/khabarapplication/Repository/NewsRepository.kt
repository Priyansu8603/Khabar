package com.example.khabarapplication.Repository

import androidx.room.Query
import com.example.khabarapplication.API.RetrofitInstance
import com.example.khabarapplication.Database.ArticleDatabase
import com.example.khabarapplication.Models.Article
import java.util.Locale.IsoCountryCode

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getTopHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun insert(article: Article) = db.getArticleDao().insert(article)

    fun getAllNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)


}