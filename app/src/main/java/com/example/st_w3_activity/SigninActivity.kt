package com.example.st_w3_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val nameEt: EditText = findViewById(R.id.name_name_et)
        val nextBtn: Button = findViewById(R.id.name_next_bt)

        nextBtn.setOnClickListener { //parameter 하나만
            if (nameEt.text.toString() != "") {
                val intent = Intent(this@SigninActivity, HelloActivity::class.java)
                intent.putExtra("user-name", nameEt.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRestart() {
        super.onRestart()

        val nameEt: EditText = findViewById(R.id.name_name_et)
        nameEt.setText("")
    }
}