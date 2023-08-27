package com.example.library

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Далее - SharedPreferences
        val switchCompat: SwitchCompat = findViewById(R.id.switch_theme)
        val tvThemeSettings: TextView = findViewById(R.id.tv_theme_settings)

        val pref = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.apply()

        if (pref.getString("UI_MODE", "DARK") == "DARK")
            tvThemeSettings.text = resources.getString(R.string.dark_theme_on)
        else
            tvThemeSettings.text = resources.getString(R.string.light_theme_on)

        switchCompat.setOnClickListener {
            if (pref.getString("UI_MODE", "LIGHT") == "LIGHT") {
                editor.putString("UI_MODE", "DARK")
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                tvThemeSettings.text = resources.getString(R.string.dark_theme_on)
            } else {
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putString("UI_MODE", "LIGHT")
                setTheme(R.style.Base_Theme_Library)
                tvThemeSettings.text = resources.getString(R.string.light_theme_on)
            }
            editor.apply()
        }
    }
}
