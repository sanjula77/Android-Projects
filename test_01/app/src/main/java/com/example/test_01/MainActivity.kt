package com.example.test_01

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonCool = findViewById<Button>(R.id.coolBtn)
        val buttonHot = findViewById<Button>(R.id.hotBtn)
        val linearLayout = findViewById<LinearLayout>(R.id.main)

        buttonCool.setOnClickListener {
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.cyan))
        }

        buttonHot.setOnClickListener {
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.deep_orange))
        }

    }
}