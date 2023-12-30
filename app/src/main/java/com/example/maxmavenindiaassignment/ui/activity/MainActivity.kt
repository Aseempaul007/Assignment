package com.example.maxmavenindiaassignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maxmavenindiaassignment.R
import com.example.maxmavenindiaassignment.adapter.BookAdapter
import com.example.maxmavenindiaassignment.data.remote.model.BookApiResponse
import com.example.maxmavenindiaassignment.data.remote.model.Item
import com.example.maxmavenindiaassignment.databinding.ActivityMainBinding
import com.example.maxmavenindiaassignment.ui.fragment.FavoritesFragment
import com.example.maxmavenindiaassignment.ui.fragment.SearchFragment
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
class MainActivity : AppCompatActivity() {

    private var viewModel: BookViewmodel? = null
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(BookViewmodel::class.java)
        setCurrentFragment(SearchFragment())
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.search->setCurrentFragment(SearchFragment())
                R.id.favorites->setCurrentFragment(FavoritesFragment())
            }
            true
        }


    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }
}