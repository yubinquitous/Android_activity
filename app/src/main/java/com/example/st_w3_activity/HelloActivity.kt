package com.example.st_w3_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.TextView
import java.util.*
import kotlin.concurrent.schedule

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val nameTv: TextView = findViewById(R.id.hello_name_tv)
        intent?.let {
            it.getStringExtra("user-name")?.let { name ->
                nameTv.text = name
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val nameTv: TextView = findViewById(R.id.hello_name_tv)
        Timer().schedule(3000){
            val intent = Intent(this@HelloActivity, MorningActivity::class.java)   //명시적 실행
            intent.putExtra("user-name", nameTv.text)
            startActivity(intent)
            finish()
        }
    }
}