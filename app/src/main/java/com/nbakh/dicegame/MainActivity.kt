package com.nbakh.dicegame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    val rng: Random = Random()
    var isFirstThrow: Boolean = true

    private lateinit var dice1textview: TextView
    private lateinit var dice2textview: TextView
    private lateinit var sumtextview: TextView
    private lateinit var resulttextview: TextView
    private lateinit var targettextview: TextView
    private lateinit var rollbutton: Button
    private lateinit var playagainbutton: Button
    private lateinit var rolldiceimageview: ImageView

    var dice1: Int = 0
    var dice2: Int = 0
    var sum: Int = 0
    var target = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice1textview = findViewById(R.id.dice1tv)
        dice2textview = findViewById(R.id.dice2tv)
        sumtextview = findViewById(R.id.sumtv)
        resulttextview = findViewById(R.id.resulttv)
        targettextview = findViewById(R.id.targettv)
        rollbutton = findViewById(R.id.rollbtn)
        playagainbutton = findViewById(R.id.playagainbtn)
        rolldiceimageview = findViewById(R.id.rolldiceiv)

        playagainbutton.visibility = View.INVISIBLE

    }

    fun rollDice(view: View) {
        dice1 = rng.nextInt(6)+1
        dice2 = rng.nextInt(6)+1
        sum = (dice1 + dice2)

        dice1textview.text = "Dice 1\n    ${dice1.toString()}"
        dice2textview.text = "Dice 2\n    ${dice2.toString()}"
        sumtextview.text = "-Score-\n    ${sum.toString()}"

        gameManager()
        rolldiceimageview.imageAlpha = 0
    }

    fun gameManager() {
        if(isFirstThrow){
            if(sum==7 || sum==11){
                resulttextview.text = "You won!"
                rollbutton.isClickable = false
                rollbutton.visibility = View.INVISIBLE
                playagainbutton.visibility = View.VISIBLE
                sumtextview.setTextColor(Color.BLUE)
            }
            else if (sum==2 || sum==3 || sum==12){
                resulttextview.text = "You loose!"
                resulttextview.setTextColor(Color.RED)
                rollbutton.isClickable = false
                rollbutton.visibility = View.INVISIBLE
                playagainbutton.visibility = View.VISIBLE
            }
            else {
                target = sum
                targettextview.text = "Target: ${target.toString()}"
                resulttextview.text = "Roll Again"
            }
            isFirstThrow = false
        }

        else if (!isFirstThrow){
            if (sum==7){
                resulttextview.text = "You loose!"
                resulttextview.setTextColor(Color.RED)
                rollbutton.isClickable = false
                rollbutton.visibility = View.INVISIBLE
                playagainbutton.visibility = View.VISIBLE

            }
            else if (sum==target){
                resulttextview.text = "You won!"
                rollbutton.isClickable = false
                rollbutton.visibility = View.INVISIBLE
                playagainbutton.visibility = View.VISIBLE
                sumtextview.setTextColor(Color.BLUE)
            }
        }
    }

    fun goToMainMenu(view: View) {
        val intent = intent
        finish()
        startActivity(intent)
    }
}