package com.example.spacetrader.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.Toast
import com.example.spacetrader.R
import kotlinx.android.synthetic.main.activity_config.*

import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val newGameButton = findViewById(R.id.newGameButton) as Button
        newGameButton.setOnClickListener {
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }

        val loadGameButton = findViewById(R.id.loadGameButton) as Button
        loadGameButton.setOnClickListener {
            Toast.makeText(this@StartActivity, "Unavailable", Toast.LENGTH_SHORT).show()
        }
    }

}
