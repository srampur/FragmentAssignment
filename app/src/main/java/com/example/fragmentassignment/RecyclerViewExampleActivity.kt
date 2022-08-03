package com.example.fragmentassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragmentassignment.databinding.ActivityRecyclerViewExampleBinding

class RecyclerViewExampleActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        example()
    }

    private fun example() {
        val list = ArrayList<String>()
        list.add("A")
        list.add("B")
        list.add("C")
        list.add("D")
        list.add("E")
        list.add("F")
        list.add("G")
        list.add("H")
        list.add("I")

        val layoutmgr = GridLayoutManager(applicationContext, 2)
        layoutmgr.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0,1 -> 2
                    else -> 1
                }
            }
        }

        binding.recvexample.layoutManager = layoutmgr
        binding.recvexample.adapter = RecUserAdapter(list)
    }
}