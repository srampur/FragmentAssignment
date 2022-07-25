package com.example.fragmentassignment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentassignment.databinding.FragmentChatBinding
import com.example.fragmentassignment.databinding.FragmentHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {
    private var number: String = ""
    private var message: String = ""

    lateinit var binding: FragmentChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            number = it.getString(ARG_PARAM1).toString()
            message = it.getString(ARG_PARAM2, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMsg.text = "Message : " + message
        binding.tvNumber.text = "Message from " + number
    }

    companion object {
        @JvmStatic
        fun newInstance(number: Int, message: String) =
            ChatFragment().apply {
                Log.e("ChatFragment", "newInstance: n=$number, msg=$message" )
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, number.toString())
                    putString(ARG_PARAM2, message)
                }
            }
    }
}