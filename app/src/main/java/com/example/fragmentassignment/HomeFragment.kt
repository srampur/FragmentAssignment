package com.example.fragmentassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentassignment.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var listener: onFragmentChangeListener

    private val errorMsg = "Please enter message."
    private val errorNumberMsg = "Please enter number."

    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(_listener: onFragmentChangeListener) =
            HomeFragment().apply {
                listener = _listener
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnhomechat.setOnClickListener {
            if (binding.tietmessage.text.isNullOrEmpty()) {
                binding.tilmessage.error = errorMsg
            } else {
                binding.tilmessage.error = null
                //send message to chat fragment
                listener.onFragmentChange(ChatFragment.newInstance())
            }
        }

        binding.btnhomecall.setOnClickListener {
            if (binding.tietnumber.text.isNullOrEmpty()) {
                binding.tilnumber.error = errorNumberMsg
            } else {
                binding.tilnumber.error = null
                //send message to call fragment
                listener.onFragmentChange(CallFragment.newInstance())
            }
        }
    }

    interface onFragmentChangeListener {
        fun onFragmentChange(fragment: Fragment)
    }
}