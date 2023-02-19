package com.example.workingapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workingapplication.databinding.CurrentItemBinding

class CurrentAdapter(val listener: Listener): RecyclerView.Adapter<CurrentAdapter.ViewHolder>() {

    val currentItem = ArrayList<Plant>()

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CurrentItemBinding.bind(item)
        fun bind(item: Plant, listener: Listener) = with(binding) {
            receiverTv.text = item.title
            textView3.text = item.price
            itemView.setOnClickListener {
                listener.onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.current_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentItem[position], listener)
    }

    override fun getItemCount(): Int {
        return currentItem.size
    }

    fun addItem(item: Plant){
        currentItem.add(item)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(plant: Plant)
    }
}