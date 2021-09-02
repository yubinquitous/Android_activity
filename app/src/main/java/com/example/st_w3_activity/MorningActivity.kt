package com.example.st_w3_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MorningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning)

        val eatBtn: Button = findViewById(R.id.morning_eat_bt)
        val nextBtn: Button = findViewById(R.id.morning_next_bt)
        var nameTv : String? = null

        intent?.let {
            it.getStringExtra("user-name")?.let { name ->
                nameTv = name
            }
        }

        eatBtn.setOnClickListener {
            eatBtn.isSelected = eatBtn.isSelected != true
        }

        nextBtn.setOnClickListener{ //parameter 하나만
            if(eatBtn.isSelected){
                val intent = Intent(this@MorningActivity, MainActivity2::class.java)
                intent.putExtra("user-name", nameTv)
                startActivity(intent)
                //finish()
                overridePendingTransition( R.anim.horizon_enter, R.anim.horizon_exit)
            }else{
                Toast.makeText(this, "밥을 다 먹어주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRestart() {
        super.onRestart()

        val eatBtn: Button = findViewById(R.id.morning_eat_bt)
//        eatBtn.isSelected = eatBtn.isSelected == false
        eatBtn?.isSelected = false
    }
}
