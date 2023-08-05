package com.example.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.lang.reflect.Type

class BooksListActivity : AppCompatActivity() {

    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_list)

        val listType: Type = object : TypeToken<List<Book>>() {}.type // чтобы указать что это список
        val list = Gson().fromJson<List<Book>>(
            BufferedReader(InputStreamReader(this.resources.openRawResource(R.raw.books))), listType)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_books_list)
        adapter = BookAdapter(list)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )


        //recyclerView.setHasFixedSize(true)


    }
}