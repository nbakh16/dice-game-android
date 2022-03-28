package com.id1720430.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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
    private lateinit var testtextview: TextView

    var dice1 = 0
    var dice2 = 0
    var sum = 0
    var target = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice1textview = findViewById(R.id.dice1tv)
        dice2textview = findViewById(R.id.dice2tv)
        sumtextview = findViewById(R.id.sumtv)
        resulttextview = findViewById(R.id.resulttv)
        targettextview = findViewById(R.id.targettv)


        testtextview = findViewById(R.id.testtv)
        testtextview.text = isFirstThrow.toString()
    }

    fun rollDice(view: View) {
        dice1 = rng.nextInt(6)+1
        dice2 = rng.nextInt(6)+1
        sum = dice1 + dice2

        dice1textview.text = dice1.toString()
        dice2textview.text = dice2.toString()
        sumtextview.text = sum.toString()

        gameManager()
    }

    fun gameManager() {
        if(isFirstThrow){
            if(sum==7 || sum==11){
                resulttextview.text = "You won!"
            }
            else if (sum==2 || sum==3 || sum==12){
                resulttextview.text = "You loose!"
            }
            else {
                target = sum
                targettextview.text = "Target: ${target.toString()}"
            }
            isFirstThrow = false
            testtextview.text = isFirstThrow.toString()
        }

        else if (!isFirstThrow){
            if (sum==7){
                resulttextview.text = "You loose!"
            }
            else if (sum==target){
                resulttextview.text = "You won!"
            }
        }
    }
}