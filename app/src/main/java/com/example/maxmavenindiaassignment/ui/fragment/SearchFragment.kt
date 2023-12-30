package com.example.maxmavenindiaassignment.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maxmavenindiaassignment.R
import com.example.maxmavenindiaassignment.adapter.BookAdapter
import com.example.maxmavenindiaassignment.data.remote.model.BookApiResponse
import com.example.maxmavenindiaassignment.data.remote.model.Item
import com.example.maxmavenindiaassignment.databinding.FragmentSearchBinding
import com.example.maxmavenindiaassignment.viewmodel.BookViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    lateinit var viewModel: BookViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSearchBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(BookViewmodel::class.java)

        binding.bookTxt.visibility=View.VISIBLE

        binding.search.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                val bookName = binding.searchBook.text.toString()
                val res = viewModel.getBooks(bookName).body()?.items

                withContext(Dispatchers.Main){
                    binding.bookTxt.visibility=View.INVISIBLE

                    binding.recyclerview.adapter = BookAdapter(requireContext(),res!!,viewModel)
                    binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
                }
            }

        }
        return binding.root
    }

}