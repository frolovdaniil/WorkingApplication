package com.example.workingapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workingapplication.databinding.DesignBinding

class ItemAdapter (val listener: Listener): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

        val plantList = ArrayList<Plant>()

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val binding = DesignBinding.bind(itemView)
            fun bind(plant: Plant, listener: Listener) = with(binding) {
                receiverTv.text = plant.title
                itemView.setOnClickListener {
                    listener.onClick(plant)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(plantList[position], listener)
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(plant: Plant)
    }

}
