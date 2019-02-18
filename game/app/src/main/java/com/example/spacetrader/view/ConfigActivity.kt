package com.example.spacetrader.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.spacetrader.R
import com.example.spacetrader.entity.Difficulty
import com.example.spacetrader.viewModel.ConfigViewModel

import kotlinx.android.synthetic.main.activity_config.*

class ConfigActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, TextWatcher {

    // view model
    private val vm = ConfigViewModel()

    //
    private var nameEditText: EditText? = null

    // Skills
    private var pointCountTextView: TextView? = null
    private var pilotSeekBar: SeekBar? = null
    private var fighterSeekBar: SeekBar? = null
    private var traderSeekBar: SeekBar? = null
    private var engineerSeekBar: SeekBar? = null

    //
    private var difficultySpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        setSupportActionBar(toolbar)

        nameEditText = findViewById(R.id.name)
        nameEditText?.addTextChangedListener(this)

        difficultySpinner = findViewById(R.id.difficultySpinner)

        val difficultyAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Difficulty.values())
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        difficultySpinner?.setAdapter(difficultyAdapter)
        difficultySpinner?.onItemSelectedListener = this

        val createButton = findViewById(R.id.createButton) as Button
        createButton.setOnClickListener {
            Toast.makeText(this@ConfigActivity, "${vm.name} -- ${vm.difficulty}", Toast.LENGTH_SHORT).show()
        }

        pointCountTextView = findViewById(R.id.pointCountTextView)
        pilotSeekBar = findViewById(R.id.pilotSeekBar)
        fighterSeekBar = findViewById(R.id.fighterSeekBar)
        traderSeekBar = findViewById(R.id.traderSeekBar)
        engineerSeekBar = findViewById(R.id.engineerSeekBar)

        pilotSeekBar?.setOnSeekBarChangeListener(seekBarChangeListener)
        fighterSeekBar?.setOnSeekBarChangeListener(seekBarChangeListener)
        traderSeekBar?.setOnSeekBarChangeListener(seekBarChangeListener)
        engineerSeekBar?.setOnSeekBarChangeListener(seekBarChangeListener)

        updateForVm()

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
    }

    // Name Text Field

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        vm.name = nameEditText?.text.toString()
    }

    override fun afterTextChanged(s: Editable?) {
        //
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //
    }

    // Difficulty Spinner

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        vm.difficulty = Difficulty.values().get(position)
    }

    // Options Menu

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    // Seek Bars

    private val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            when (seekBar) {
                pilotSeekBar -> vm.updateSkill(vm.pilotSkill, progress)
                fighterSeekBar -> vm.updateSkill(vm.fighterSkill, progress)
                traderSeekBar -> vm.updateSkill(vm.traderSkill, progress)
                engineerSeekBar -> vm.updateSkill(vm.engineerSkill, progress)
            }

            updateForVm()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            //
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            //
        }
    }

    fun updateForVm() {
        pointCountTextView?.text = "${vm.remainingPoints} / ${vm.totalPointsAvailable}"

        pilotSeekBar?.progress = vm.pilotSkill._points
        fighterSeekBar?.progress = vm.fighterSkill._points
        traderSeekBar?.progress = vm.traderSkill._points
        engineerSeekBar?.progress = vm.engineerSkill._points

        difficultySpinner?.setSelection(vm.difficulty.ordinal)
    }
}
