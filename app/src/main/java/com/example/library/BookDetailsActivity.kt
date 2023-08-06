package com.example.library

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val tvBookName: TextView = findViewById(R.id.tv_book_name_book_details_activity)
        val tvAuthor: TextView = findViewById(R.id.tv_author_book_details_activity)
        val tvDescription: TextView = findViewById(R.id.tv_description_book_details_activity)

        val author = intent.getStringExtra(AUTHOR_KEY)
        val bookName = intent.getStringExtra(NAME_KEY)
        val description = intent.getStringExtra(DESCRIPTION_KEY)

        tvBookName.text = bookName
        tvAuthor.text = author
        tvDescription.text = description
    }

    companion object {
        const val NAME_KEY = "NAME_KEY"
        const val AUTHOR_KEY = "AUTHOR_KEY"
        const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
    }
}