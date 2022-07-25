package com.example.fragmentassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragmentassignment.databinding.ActivityAssignmentsBinding
import com.google.android.material.snackbar.Snackbar

class AssignmentsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAssignmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onLoginButtonClick()
    }

    private fun onLoginButtonClick() {
        binding.btnFragmentCommunicationExample.setOnClickListener {
            Toast.makeText(it.context, binding.btnFragmentCommunicationExample.text, Toast.LENGTH_LONG).show()
            startActivity(Intent(it.context, SuccessLoginActivity::class.java))
        }
    }
}