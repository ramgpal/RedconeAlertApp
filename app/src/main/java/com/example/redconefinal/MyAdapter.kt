package com.example.redconefinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redconefinal.databinding.ListItemBinding

class MyAdapter(private val userList: List<User>, private val onItemClick: (User) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.binding.nameTextView.text = currentItem.name
        holder.binding.datetimeTextView.text = currentItem.datetime
        holder.binding.locationTextView.text = currentItem.Location
        holder.itemView.setOnClickListener {
            onItemClick(currentItem)
        }
    }
}
