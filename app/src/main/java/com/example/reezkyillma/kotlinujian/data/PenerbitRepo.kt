package com.example.reezkyillma.kotlinujian.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.reezkyillma.kotlinujian.data.data_model.Book
import com.example.reezkyillma.kotlinujian.data.db_only.BookDAO
import com.example.reezkyillma.kotlinujian.data.db_only.BookDb


class PenerbitRepo(application: Application) {

    private val bookDao : BookDAO

    init {
        val bookDatabase = BookDb.getInstance(application)
        bookDao = bookDatabase.bookDao()
    }

    /**
     * menampilkan data tapi secara descending
     */
    fun getAllBook() : LiveData<List<Book>> {

        return bookDao.getAll()
    }

    fun insertBook(book: Book){

        bookDao.insert(book)
    }

    fun findBook(id : Int): LiveData<Book> {

        return bookDao.find(id)
    }

}