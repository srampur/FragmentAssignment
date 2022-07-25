package com.example.fragmentassignment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CallFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CallFragment : Fragment() {

    private var number: String = ""
    private var message: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            number = it.getString(ARG_PARAM1).toString()
            message = it.getString(ARG_PARAM2, "")
        }

        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(number: Int, message: String) =
            CallFragment().apply {
                Log.e("CallFragment", "newInstance: n=$number, msg=$message" )
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, number.toString())
                    putString(ARG_PARAM2, message)
                }
            }
    }
}