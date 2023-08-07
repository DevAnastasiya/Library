package com.example.library.data

import android.content.Context
import com.example.library.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.lang.reflect.Type

fun createBooksList(context: Context): List<Book> {

    try {
        val listType: Type =
            object : TypeToken<List<Book>>() {}.type // token - чтобы указать что это список
        return Gson().fromJson(
            BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.books))), listType
        )
    }
    catch (e: Exception) {
     throw FileNotFoundException()
    }
}
