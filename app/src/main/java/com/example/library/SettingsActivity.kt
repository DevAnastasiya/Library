package com.example.library

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.example.library.Library.Companion.DARK
import com.example.library.Library.Companion.LIGHT
import com.example.library.Library.Companion.UI_MODE

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchCompat: SwitchCompat = findViewById(R.id.switch_theme)
        val tvThemeSettings: TextView = findViewById(R.id.tv_theme_settings)

        // Далее - SharedPreferences

        val pref = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.apply()

        if (pref.getString(UI_MODE, LIGHT) == LIGHT) {
            tvThemeSettings.text = resources.getString(R.string.light_theme_on)
            switchCompat.isChecked = false
        } else {
            tvThemeSettings.text = resources.getString(R.string.dark_theme_on)
            switchCompat.isChecked = true

        }

        switchCompat.setOnCheckedChangeListener { _, _ ->
            if (pref.getString(UI_MODE, LIGHT) == LIGHT) {
                editor.putString(UI_MODE, DARK)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                tvThemeSettings.text = resources.getString(R.string.dark_theme_on)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putString(UI_MODE, LIGHT)
                setTheme(R.style.Base_Theme_Library)
                tvThemeSettings.text = resources.getString(R.string.light_theme_on)
            }
            editor.apply()
        }
    }
}
