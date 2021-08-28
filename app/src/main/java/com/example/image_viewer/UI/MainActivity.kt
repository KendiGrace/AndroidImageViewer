package com.example.image_viewer.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.image_viewer.R

class MainActivity : AppCompatActivity() {
    lateinit var btnStart:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            var intent=Intent(baseContext,ImageActivity::class.java)
            startActivity(intent)

        }
    }
}