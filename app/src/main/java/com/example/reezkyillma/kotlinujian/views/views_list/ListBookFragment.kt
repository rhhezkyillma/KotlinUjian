package com.example.reezkyillma.kotlinujian.views.views_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.reezkyillma.kotlinujian.R
import com.example.reezkyillma.kotlinujian.data.data_model.Book
import com.example.reezkyillma.kotlinujian.views.views_details.DetailAct
import kotlinx.android.synthetic.main.fragment_for_list_book.*

class ListBookFragment :android.support.v4.app.Fragment(), ListBookAdapter.OnItemClickListener {

    private lateinit var viewModel: BookListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_for_list_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
            //            Toast.makeText(activity.applicationContext, "Test Click FAB", Toast.LENGTH_SHORT)
//                .show()
//            val intent = Intent(context, AddPeopleData::class.java)
//            startActivity(intent)
            view.findNavController().navigate(R.id.action_listBookFragment_to_fragmentAddBook)
        }

        viewModel.getBookList().observe(this, Observer<List<Book>> {
                books -> books?.let {
            populateBookList(books)
        }
        })

    }

    override fun onItemClick(book: Book, itemView: View) {

//        val detailIntent = Intent(context, DetailAct::class.java)
//        detailIntent.putExtra(getString(R.string.book_id), book.id)
//        startActivity(detailIntent)
        val detailBundle = Bundle().apply{
            putInt(getString(R.string.book_id), book.id)
        }
        view?.findNavController()?.navigate(R.id.action_listBookFragment_to_detailFragment, detailBundle)
    }

    private fun populateBookList(booklist : List<Book>){
        bookRecyclerView.adapter = ListBookAdapter(booklist, this)
    }


}