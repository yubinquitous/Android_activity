package com.example.st_w3_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import kotlin.concurrent.schedule

class NightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_night)

        val nameTv: TextView = findViewById(R.id.night_name_tv)
        intent?.let {
            it.getStringExtra("user-name")?.let { name ->
                nameTv.text = name
            }
        }

    }

    override fun onResume() {
        super.onResume()
        val nameTv: TextView = findViewById(R.id.night_name_tv)
        Timer().schedule(2000){
            val intent = Intent(this@NightActivity, HelloActivity::class.java)   //명시적 실행
            intent.putExtra("user-name", nameTv.text)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}