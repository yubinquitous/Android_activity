package com.example.st_w3_activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoIv : ImageView = findViewById(R.id.splash_logo_iv)
        AnimationUtils.loadAnimation(this, R.anim.rotation ).also { rotation ->
            logoIv.startAnimation(rotation)
        }
    }

    override fun onResume() {
        super.onResume()

        Timer().schedule(5000){
            val intent = Intent(this@SplashActivity, NameActivity::class.java)   //명시적 실행
            startActivity(intent)
            finish()
        }
    }
}
