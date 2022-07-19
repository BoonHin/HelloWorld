package com.example.helloworld

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var diceImage:ImageView //var = value can be changed, not a constant
    lateinit var numberText: TextView
    lateinit var editPlayerTxt: EditText
    lateinit var playerNameTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPlayerTxt = findViewById(R.id.editPlayerNameET)
        playerNameTxt = findViewById(R.id.playerName)
        val updateBtn: Button = findViewById(R.id.updateButton)
        updateBtn.setOnClickListener{updateName(it)}

        diceImage = findViewById(R.id.diceImg)
        numberText = findViewById(R.id.numberText)
        val rollButton: Button = findViewById(R.id.rollButton)
        //OR val rollButton = findViewById<Button>(R.id.rollBtn)
        rollButton.setOnClickListener{ rollDice() }
    }

    private fun updateName(view : View){
        playerNameTxt.text = editPlayerTxt.text

        editPlayerTxt.text.clear()
        editPlayerTxt.clearFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
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