package com.example.spacetrader.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.spacetrader.R
import com.example.spacetrader.model.Difficulty

import kotlinx.android.synthetic.main.activity_config.*
import kotlinx.android.synthetic.main.content_start.*

class ConfigActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var difficultySpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        setSupportActionBar(toolbar)

        difficultySpinner = findViewById(R.id.difficultySpinner)

        val difficultyAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Difficulty.values())
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        difficultySpinner?.setAdapter(difficultyAdapter)

        val createButton = findViewById(R.id.createButton) as Button
        createButton.setOnClickListener {
            Toast.makeText(this@ConfigActivity, "New player with name ___ and difficulty ____", Toast.LENGTH_SHORT).show()
        }

        val pilotSeekBar = findViewById<SeekBar>(R.id.pilotSeekBar)
        pilotSeekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(pilotSeekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
            }

            override fun onStartTrackingTouch(pilotSeekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(pilotSeekBar: SeekBar) {
                Toast.makeText(this@ConfigActivity, "Pilot points: " + pilotSeekBar.progress, Toast.LENGTH_SHORT).show()
            }
        })


        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
