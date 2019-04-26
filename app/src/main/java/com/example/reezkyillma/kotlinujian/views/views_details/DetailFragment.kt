package com.example.reezkyillma.kotlinujian.views.views_details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reezkyillma.kotlinujian.R
import com.example.reezkyillma.kotlinujian.data.data_model.Book
import kotlinx.android.synthetic.main.fragment_add_book.*
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.layout_list_item.*

class DetailFragment : Fragment() {
    private lateinit var viewModel: BookDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(BookDetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_details, container, true)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bookId = arguments?.getInt(getString(R.string.book_id))
        bookId?.let{
            viewModel.getBookDetails(bookId).observe(this, Observer { bookDetails ->
                populatebookDetails(bookDetails)
            })
        }
    }

    private  fun populatebookDetails(book: Book?){
        textName.text = book?.name
        textMet.text = book?.metAt
        Penerbit.text = book?.penerbit
        textViewEmail.text = book?.email
        textViewFacebook.text = book?.facebook
        textViewTwitter.text = book?.twitter
    }
}