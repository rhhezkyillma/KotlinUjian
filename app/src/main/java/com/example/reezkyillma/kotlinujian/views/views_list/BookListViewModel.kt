package com.example.reezkyillma.kotlinujian.views.views_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.example.reezkyillma.kotlinujian.StartApp
import com.example.reezkyillma.kotlinujian.data.data_model.Book
import com.example.reezkyillma.kotlinujian.data.data_net.BookListInfo.Companion.bookList

class BookListViewModel(application: Application) :AndroidViewModel(application) {
    private val bookRepo = getApplication<StartApp>().getBookRepo()
    private val bookList = MediatorLiveData<List<Book>>()

    init {
        getAllBook()
    }

    fun getBookList() : LiveData<List<Book>> {
        return bookList
    }

    fun getAllBook(){
        bookList.addSource(bookRepo.getAllBook()){
                books -> bookList.postValue(books)
        }
    }
}