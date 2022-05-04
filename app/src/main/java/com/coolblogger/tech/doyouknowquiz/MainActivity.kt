package com.coolblogger.tech.doyouknowquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setData.getQuesion()
        btnSplash.setOnClickListener {
            if (nameEt.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(this,QuestionActivity::class.java)
                intent.putExtra("${setData.name}", nameEt.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}