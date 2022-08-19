package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        //Dice roll on start
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Getting the correct image from dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Updating the screen image with correct image
        diceImage.setImageResource(drawableResource)

        //Setting content description for screen readers
        diceImage.contentDescription = diceRoll.toString()

    }
}

/**
 *
 * Builds Dice object
 */
class Dice(private val numSides: Int) {
    //Randomly selects number between 1 and the number of sides
    fun roll(): Int {
        return (1..numSides).random()
    }
}