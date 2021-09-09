package com.example.blocky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.discoding.R

class Appmain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val plus = findViewById<Button>(R.id.plus)
        plus.setOnClickListener {
            val gotocreate_bot = Intent(this, Explain::class.java)
            startActivity(gotocreate_bot)
        }
    }
}