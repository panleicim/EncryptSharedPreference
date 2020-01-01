package com.lpa.encryptedsharedpreferences.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lpa.encryptedsharedpreferences.R
import com.lpa.encryptedsharedpreferences.model.UserModel

class UserItemAdapter(var list: List<UserModel>, val context: Context) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.user_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun reload(newList: List<UserModel>) {
        list = newList
        notifyDataSetChanged()
    }

}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvLastName = view.findViewById<TextView>(R.id.tvLastName)
    val tvFirstName = view.findViewById<TextView>(R.id.tvFirstName)
    val tvMail = view.findViewById<TextView>(R.id.tvMail)


    fun bind(userModel: UserModel) {
        tvLastName.text = userModel.lastName
        tvFirstName.text = userModel.firstName
        tvMail.text = userModel.mailAddress
    }
}