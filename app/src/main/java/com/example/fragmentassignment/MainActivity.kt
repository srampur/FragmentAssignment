package com.example.fragmentassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragmentassignment.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val usernameErrorMsg = "Username can not be empty"
    private val passwordErrorMsg = "Password can not be empty"
    private val usernamePasswordErrorMsg = "Please enter username and password."
    private var successMsg = "Welcome "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onLoginButtonClick()
    }

    private fun onLoginButtonClick() {
        binding.btnlogin.setOnClickListener {
            val validationResult = validateUsernameAndPassword()
            if (validationResult) {
                successMsg += binding.tietusername.text
                Toast.makeText(it.context, successMsg, Toast.LENGTH_LONG).show()
                startActivity(Intent(it.context, SuccessLoginActivity::class.java))
            } else {
                //Toast.makeText(it.context, "Please enter username and password.", Toast.LENGTH_LONG).show()
                Snackbar.make(it, usernamePasswordErrorMsg, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateUsernameAndPassword(): Boolean {
        var result = false
        binding.tietusername.also {
            if (it.text.isNullOrEmpty()) {
                it.error = usernameErrorMsg
            } else {
                it.error = null
            }
        }

        binding.tietpassword.also {
            if (it.text.isNullOrEmpty()) {
                it.error = passwordErrorMsg
            } else {
                it.error = null
            }
        }

        if ((binding.tietusername.text?.trim()?.isNotEmpty() == true) &&
            (binding.tietpassword.text?.trim()?.isNotEmpty() == true)
        ) {
            result = true
            binding.tietusername.error = null
            binding.tietpassword.error = null
        }

        return result
    }
}