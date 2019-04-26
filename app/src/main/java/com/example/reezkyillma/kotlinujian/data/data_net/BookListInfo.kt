package com.example.reezkyillma.kotlinujian.data.data_net

import com.example.reezkyillma.kotlinujian.data.data_model.Book

class BookListInfo {
    companion object {
        var bookList = initBookList()

        //add dumy datta

        private fun initBookList() : MutableList<Book> {
            var po_books = mutableListOf<Book>()
            po_books.add(
                Book(
                    "Nanti Kita Cerita Tentang Hari Ini",
                    "Gramedia Mall Puri Indah",
                    "Gramedia Center",
                    "nktch@gmail.com",
                    "fb.me/rezkycaroline",
                    "twitter.com/rhhezky",
                    id = 1
                )
            )

            po_books.add(
                Book(
                    "Nanti Kita Cerita Tentang Hari Ini",
                    "Gramedia Mall Puri Indah",
                    "Gramedia Center",
                    "nktch@gmail.com",
                    "fb.me/rezkycaroline",
                    "twitter.com/rhhezky",
                    id = 2
                )
            )

            po_books.add(
                Book(
                    "Nanti Kita Cerita Tentang Hari Ini",
                    "Gramedia Mall Puri Indah",
                    "Gramedia Center",
                    "nktch@gmail.com",
                    "fb.me/rezkycaroline",
                    "twitter.com/rhhezky",
                    id = 3
                )
            )

            return po_books
        }
        }

    }
