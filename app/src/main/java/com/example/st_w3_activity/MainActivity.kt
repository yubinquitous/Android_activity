package com.example.st_w3_activity

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var isDark = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.horizon_enter, 0)
        setContentView(R.layout.activity_main)

        val themeBtn: Button = findViewById(R.id.main_theme_bt)
        val nameTv: TextView = findViewById(R.id.main_name_tv)

        themeBtn.setOnClickListener {
            switchTheme()
        }

        intent?.let {
            it.getStringExtra("user-name")?.let { name ->
                nameTv.text = name
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val nextBtn: Button = findViewById(R.id.main_next_bt)
        val nameTv: TextView = findViewById(R.id.main_name_tv)
        
        nextBtn.setOnClickListener { //parameter 하나만
            val intent = Intent(this@MainActivity, NightActivity::class.java)
            intent.putExtra("user-name", nameTv.text)
            startActivity(intent)
        }
    }

    private fun switchTheme() {
        val parent: ConstraintLayout = findViewById(R.id.main_parent_layout)
        val nameTv: TextView = findViewById(R.id.main_name_tv)
        val todoTv: TextView = findViewById(R.id.main_todo_tv)
        val themeBtn: Button = findViewById(R.id.main_theme_bt)
        val cb1: CheckBox = findViewById(R.id.main_cb1_cb)
        val cb2: CheckBox = findViewById(R.id.main_cb2_cb)
        val cb3: CheckBox = findViewById(R.id.main_cb3_cb)
        val cb4: CheckBox = findViewById(R.id.main_cb4_cb)
        val cb5: CheckBox = findViewById(R.id.main_cb5_cb)
        val cb6: CheckBox = findViewById(R.id.main_cb6_cb)

        if (isDark) {
            parent.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            nameTv.setTextColor(ContextCompat.getColor(this, R.color.darkgray))
            todoTv.setTextColor(ContextCompat.getColor(this, R.color.darkgray))
            cb1.setTextColor(ContextCompat.getColor(this, R.color.darkgray))
            cb2.setTextColor(ContextCompat.getColor(this, R.color.darkgray))
            cb3.setTextColor(ContextCompat.getColor(this, R.color.darkgray))
            cb4.setTextColor(ContextCompat.getColor(this, R.color.darkgray))
            cb5.setTextColor(ContextCompat.getColor(this, R.color.darkgray))
            cb6.setTextColor(ContextCompat.getColor(this, R.color.darkgray))

            themeBtn.text = "DARK"
            isDark = false
        } else {
            parent.setBackgroundColor(ContextCompat.getColor(this, R.color.darkgray))
            nameTv.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))
            todoTv.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))
            cb1.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))
            cb2.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))
            cb3.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))
            cb4.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))
            cb5.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))
            cb6.setTextColor(ContextCompat.getColor(this, R.color.dark_yellow))

            themeBtn.text = "LIGHT"
            isDark = true
        }
    }
}