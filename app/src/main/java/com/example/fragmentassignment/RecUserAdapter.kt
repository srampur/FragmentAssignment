package com.example.fragmentassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class RecUserAdapter(private var list: ArrayList<String>): RecyclerView.Adapter<RecUserAdapter.UserViewHolder>() {
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var name = view.findViewById<AppCompatTextView>(R.id.tvRecExample)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_example_data, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

}