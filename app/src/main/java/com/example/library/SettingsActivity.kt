package com.example.library

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switchThemeSettings: SwitchCompat = findViewById(R.id.switch_theme)
        val tvThemeSettings: TextView = findViewById(R.id.tv_theme_settings)

        val pref = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.apply()

        if (switchThemeSettings.isChecked)
            tvThemeSettings.text = "Ночная тема: включена"
        else
            tvThemeSettings.text = "Ночная тема: отключена"

        switchThemeSettings.setOnClickListener {
            if (switchThemeSettings.isChecked) {
                editor.putString("UI_MODE", "DARK")
                tvThemeSettings.text = "Ночная тема: включена"
            } else {
                editor.putString("UI_MODE", "LIGHT")
                tvThemeSettings.text = "Ночная тема: отключена"
            }
            editor.apply()
        }
    }
}
