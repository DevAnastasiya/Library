package com.example.library

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class Library : Application() {

    override fun onCreate() {
        super.onCreate()

        val pref = getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)

        if (pref.contains(UI_MODE).not()) {
            val editor = pref.edit()
            editor.putString(UI_MODE, LIGHT)
            editor.apply()
        } else {
            if (pref.getString(UI_MODE, LIGHT) == LIGHT) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    companion object {

        const val UI_MODE = "UI_MODE"
        const val DARK = "DARK"
        const val LIGHT = "LIGHT"
        const val SETTINGS = "SETTINGS"
    }
}