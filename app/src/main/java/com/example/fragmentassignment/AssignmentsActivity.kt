package com.example.fragmentassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragmentassignment.databinding.ActivityAssignmentsBinding

class AssignmentsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAssignmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        assignments()
    }

    private fun assignments() {
        binding.btnFragmentCommunicationExample.setOnClickListener {
            Toast.makeText(it.context, binding.btnFragmentCommunicationExample.text, Toast.LENGTH_LONG).show()
            startActivity(Intent(it.context, SuccessLoginActivity::class.java))
        }

        binding.btnSpinnerExample.setOnClickListener {
            Toast.makeText(it.context, binding.btnSpinnerExample.text, Toast.LENGTH_SHORT).show()
            startActivity(Intent(it.context, SpinnerExampleActivity::class.java))
        }
    }
}