package com.example.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val booksList: List<Book>, private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        // создаёт и возвращает вьюхолдер
        val itemView = LayoutInflater
            .from(parent.context) // получили контекст из RV
            .inflate(R.layout.item_view, parent, false) // теперь ViewHolder хранит в себе вьюшку
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = booksList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bookNameTextView.text = booksList[position].name
        holder.authorTextView.text = booksList[position].author

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
    }
}

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // сначала мы передаем itemView в BookViewHolder, а тот передаёт его в конструктор род.класса RecyclerView.ViewHolder
    val bookNameTextView: TextView = itemView.findViewById(R.id.tv_book_name_item_view)
    val authorTextView: TextView = itemView.findViewById(R.id.tv_author_item_view)
}