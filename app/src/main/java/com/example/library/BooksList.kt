package com.example.library

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

fun createBooksList(context: Context): List<Book> {

    val listType: Type =
        object : TypeToken<List<Book>>() {}.type // token - чтобы указать что это список
    return Gson().fromJson(
        BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.books))), listType
    )
}
