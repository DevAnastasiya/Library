package com.example.library

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        val btnSettings: FloatingActionButton = findViewById(R.id.btn_settings)

        btnSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val NAME_KEY = "NAME_KEY"
        const val AUTHOR_KEY = "AUTHOR_KEY"
        const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
    }
}