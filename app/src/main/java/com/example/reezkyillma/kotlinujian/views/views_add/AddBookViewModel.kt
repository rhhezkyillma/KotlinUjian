package com.example.reezkyillma.kotlinujian.views.views_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.reezkyillma.kotlinujian.StartApp
import com.example.reezkyillma.kotlinujian.data.data_model.Book


class AddBookViewModel(application: Application) : AndroidViewModel(application) {

    private val bookRepository = getApplication<StartApp>().getBookRepo()

    fun addBook(book: Book) {
        bookRepository.insertBook(book)
    }

}