package com.example.reezkyillma.kotlinujian.views.views_add

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.reezkyillma.kotlinujian.R
import com.example.reezkyillma.kotlinujian.data.data_model.Book
import kotlinx.android.synthetic.main.fragment_add_book.*

class FragmentAddBook : android.support.v4.app.Fragment(){
    lateinit var btn_ : Button
    private lateinit var viewModel: AddBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddBookViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(
            R.layout.fragment_add_book,
            container, false)
        btn_ = view.findViewById(R.id.btn_)
        return view
    }

    private fun saveBookInfo(){
        val book = Book(
            textInputName.editText?.text.toString(),
            textInputMetAt.editText?.text.toString(),
            textInputPenerbit.editText?.text.toString(),
            textInputEmail.editText?.text.toString(),
            textInputFacebook.editText?.text.toString(),
            textInputTwitter.editText?.text.toString()
        )

        viewModel.addBook(book)
        Navigation.findNavController(view!!).navigateUp()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_.setOnClickListener {
            saveBookInfo()
        }
    }
}