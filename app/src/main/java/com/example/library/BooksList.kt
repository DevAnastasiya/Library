package com.example.library

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

//fun createBooksList(context: Context, file: String): String? {
//
//    val jsonArr: JSONArray
//    var bookNamesList = ArrayList<String>()
//    var authorsList = ArrayList<String>()
//
//     try {
//        jsonArr = context.assets.open(file)
//            .bufferedReader().use { it.readLines() }
//        for (i in jsonArr.indices) {
//            val jsonObject: JSONObject = jsonArr.getJSONObject(i)
//            bookNamesList.add(jsonObject.getString("name"))
//        }
//    } catch (e: IOException) { // Input-Output
//        println(e.message)
//        null
//    }
//}
