package com.example.maxmavenindiaassignment.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.maxmavenindiaassignment.R
import com.example.maxmavenindiaassignment.data.remote.model.Item
import com.example.maxmavenindiaassignment.databinding.BookItemBinding
import com.example.maxmavenindiaassignment.viewmodel.BookViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookAdapter(
    private val context: Context,
    private val books: List<Item>,
    private val viewmodel: BookViewmodel
): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: BookItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        val pos = position+1

        if(isPrime(pos) && pos!=2){
            holder.binding.cardHolder.setBackgroundColor(Color.BLUE)
        }else if(pos%2==0){
            holder.binding.cardHolder.setBackgroundColor(Color.GREEN)
        } else{
            holder.binding.cardHolder.setBackgroundColor(ContextCompat.getColor(context, R.color.orage))
        }

        val imageUrl =
            "\"" + books.get(position).volumeInfo?.imageLinks?.thumbnail + "\""
        Log.d("MYTAG", imageUrl)
        holder.binding.number.text = (position+1).toString()
        holder.binding.bookTitle.text = books.get(position).volumeInfo?.title
        holder.binding.bookDescription.text = books.get(position).volumeInfo?.description
        holder.binding.bookAuthor.text = books.get(position).volumeInfo?.authors?.get(0)!!
        holder.binding.page.text = books.get(position).volumeInfo!!.pageCount.toString()
        Glide.with(context).load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.picture)
            .into(holder.binding.newsImage)


        holder.binding.favourite.setOnClickListener {
            Toast.makeText(context, "Added to Favourites", Toast.LENGTH_SHORT).show()
            CoroutineScope(Dispatchers.IO).launch {
                viewmodel.saveBook(books.get(position))
            }
        }
    }

    fun isPrime(number: Int): Boolean {
        if(number==1){
            return false
        }
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}