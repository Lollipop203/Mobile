package com.example.week3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.week3.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val birthdayTextView: TextView = findViewById(R.id.textView)
        val nameTextView: TextView = findViewById(R.id.textView2)


        birthdayTextView.text = getString(R.string.birthday_text)
        nameTextView.text = getString(R.string.name_text)
    }
}
