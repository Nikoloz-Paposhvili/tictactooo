package com.example.myapplicationtictactoe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var player1: EditText
    private lateinit var player2: EditText
    private lateinit var startbutton: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        player1 = findViewById(R.id.editTextTextPersonName)
        player2 = findViewById(R.id.editTextTextPersonName2)
        startbutton = findViewById(R.id.button)

        startbutton.setOnClickListener {
            if (player1.text.toString().length>2 && player2.text.toString().length>2){
                intent = Intent(applicationContext, gameActivity::class.java)
                intent.putExtra("name1", player1.text.toString())
                intent.putExtra("name2", player2.text.toString())
                startActivity(intent)
            }
        }
    }

}