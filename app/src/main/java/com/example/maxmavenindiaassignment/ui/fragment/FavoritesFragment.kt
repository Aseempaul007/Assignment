package com.example.maxmavenindiaassignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maxmavenindiaassignment.R
import com.example.maxmavenindiaassignment.adapter.BookAdapter
import com.example.maxmavenindiaassignment.databinding.FragmentFavoritesBinding
import com.example.maxmavenindiaassignment.databinding.FragmentSearchBinding
import com.example.maxmavenindiaassignment.viewmodel.BookViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesFragment : Fragment() {

    lateinit var binding: FragmentFavoritesBinding
    lateinit var viewModel: BookViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentFavoritesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(BookViewmodel::class.java)


            CoroutineScope(Dispatchers.IO).launch{
                val res = viewModel.showAllBooks()

                withContext(Dispatchers.Main){
                    binding.favouriteRecycler.adapter = BookAdapter(requireContext(),res,viewModel)
                    binding.favouriteRecycler.layoutManager = LinearLayoutManager(requireContext())
                }
            }

        return binding.root
    }

    companion object
}