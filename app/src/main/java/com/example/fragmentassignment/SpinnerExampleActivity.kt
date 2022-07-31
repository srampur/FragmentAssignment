package com.example.fragmentassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.fragmentassignment.databinding.ActivitySpinnerExampleBinding

class SpinnerExampleActivity : AppCompatActivity() {
    lateinit var binding: ActivitySpinnerExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spinnerExample()
    }

    /**
     * TODO
     * 1. based on country load country specific state list
     * 2. based on state load state specific place list
     */
    private fun spinnerExample() {
        val countryList = arrayListOf<String>("India", "USA")

        val stateList = arrayListOf<String>("Karnataka", "Maharashtra")

        val placeKaList = arrayListOf<String>("Bengaluru", "Mysore", "Kalaburagi")

        val placeMhList = arrayListOf<String>("Mumbai", "Pune", "Solapur")

        val arrayAdapterCountry = ArrayAdapter(this, android.R.layout.simple_spinner_item, countryList)
        binding.spincountry.adapter = arrayAdapterCountry

        val arrayAdapterState = ArrayAdapter(this, android.R.layout.simple_spinner_item, stateList)
        binding.spinstate.adapter = arrayAdapterState

        val arrayAdapterPlace = ArrayAdapter(this, android.R.layout.simple_spinner_item, placeKaList)
        binding.spinplace.adapter = arrayAdapterPlace

        binding.spincountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvcountry.text = "${resources.getString(R.string.choose_country)} ${countryList[position]}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.spinstate.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvstate.text = "${resources.getString(R.string.choose_state)} ${stateList[position]}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.spinplace.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.tvplace.text = "${resources.getString(R.string.choose_place)} ${placeKaList[position]}"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}