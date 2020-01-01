package com.lpa.encryptedsharedpreferences.rawdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lpa.encryptedsharedpreferences.R

class RawDataAdapter(var list: List<RawDataModel>, val context: Context) :
    RecyclerView.Adapter<RawDataItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RawDataItemViewHolder {
        return RawDataItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rawdata_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: RawDataItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun reload(newList: List<RawDataModel>) {
        this.list = newList
        notifyDataSetChanged()
    }

}


class RawDataItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvKey = view.findViewById<TextView>(R.id.tvKey)
    val tvValue = view.findViewById<TextView>(R.id.tvValue)

    fun bind(data: RawDataModel) {
        tvKey.text = data.key
        tvValue.text = data.value
    }
}