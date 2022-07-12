package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var diceImage:ImageView //var = value can be changed, not a constant
    lateinit var numberText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.diceImg)
        numberText = findViewById(R.id.numberText)
        val rollButton: Button = findViewById(R.id.rollButton)
        //OR val rollButton = findViewById<Button>(R.id.rollBtn)
        rollButton.setOnClickListener{ rollDice() }
    }

    private fun rollDice(){
        Toast.makeText(this, "Roll !",
            Toast.LENGTH_SHORT).show()

        val randomNum = (1..6).random() //val is a constant, value cannot be change
//        val diceImage: ImageView = findViewById(R.id.diceImg)
        val imgSrc = when(randomNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imgSrc)
//        val numberText: TextView = findViewById(R.id.numberText)
        numberText.text = randomNum.toString()
    }

}