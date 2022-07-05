package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener{ rollDice() }
    }

    private fun rollDice(){
        Toast.makeText(this, "Roll !",
            Toast.LENGTH_LONG).show()


        val randomNum = (1..6).random()

        val numberText: TextView = findViewById(R.id.numberText)
        numberText.text = randomNum.toString()
    }

}