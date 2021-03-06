package com.example.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            //   binding.textView.text = (1..6).random().toString()
            rollDice()
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG).show()
        }

    }

    //======================================================
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.imageView.setImageResource(drawableResource)
        // Update the content description
        binding.imageView.contentDescription = diceRoll.toString()
        Toast.makeText(this, binding.imageView.contentDescription, Toast.LENGTH_SHORT)
            .show()//to descripe the num
    }
    //===================================================
}

class Dice(var diceSides: Int) {
    fun roll(): Int {
        return (1..diceSides).random()
    }
}