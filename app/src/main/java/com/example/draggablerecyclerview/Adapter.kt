package com.example.draggablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class Adapter(
    private var items : List<Model> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return items[position].pk.hashCode().toLong()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.textViewTitle.text = item.title
        holder.itemView.textViewContents.text = item.contents
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) { }
}