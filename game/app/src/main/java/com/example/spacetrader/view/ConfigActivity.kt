package com.example.spacetrader.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.spacetrader.R
import com.example.spacetrader.model.Difficulty

import kotlinx.android.synthetic.main.activity_config.*

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
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
