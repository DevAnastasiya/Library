package com.example.library

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BooksListActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var adapter: BookAdapter
    private lateinit var list: List<Book> // нужен для onItemClick()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_list)

        // JSON list
        list = createBooksList(this)
        this.list = list

        // RV init
        val recyclerView = findViewById<RecyclerView>(R.id.rv_books_list)
        adapter = BookAdapter(list, this)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
    }

    // Navigation
    override fun onItemClick(position: Int) {
        val intent = Intent(this, BookDetailsActivity::class.java)

        intent.putExtra(AUTHOR_KEY, list[position].author)
        intent.putExtra(NAME_KEY, list[position].name)
        intent.putExtra(DESCRIPTION_KEY, list[position].description)

        startActivity(intent)
    }

    companion object {
        const val NAME_KEY = "NAME_KEY"
        const val AUTHOR_KEY = "AUTHOR_KEY"
        const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
    }
}