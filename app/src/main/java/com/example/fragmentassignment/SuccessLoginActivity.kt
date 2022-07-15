package com.example.fragmentassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmentassignment.databinding.ActivitySuccessLoginBinding

class SuccessLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnchat.setOnClickListener {
            refreshFrameLayout(ChatFragment.newInstance())
        }

        binding.btncall.setOnClickListener {
            refreshFrameLayout(CallFragment.newInstance())
        }

        binding.home.setOnClickListener {
            refreshFrameLayout(HomeFragment.newInstance())
        }

        binding.settings.setOnClickListener {
            refreshFrameLayout(SettingsFragment.newInstance())
        }
    }

    private fun refreshFrameLayout(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.framelayout.id, fragment)
            commit()
        }
    }
}