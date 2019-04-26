package com.example.reezkyillma.kotlinujian.views.views_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.example.reezkyillma.kotlinujian.StartApp
import com.example.reezkyillma.kotlinujian.data.data_model.Book

class BookDetailViewModel (application: Application) : AndroidViewModel(application) {

    private val bookRepository = getApplication<StartApp>().getBookRepo()
    private val bookId = MutableLiveData<Int>()


    fun getBookDetails(id: Int): LiveData<Book> {
        bookId.value = id
        val bookDetails = Transformations.switchMap<Int, Book>(bookId) { id ->
            bookRepository.findBook(id)
        }
        return bookDetails
    }

}