package com.nbakh.dicegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    private lateinit var playButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        playButton = findViewById(R.id.playbtn)
    }

    fun playGame(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}