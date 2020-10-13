package com.example.draggablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import java.util.*

class Adapter(
    private var items : List<Model> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() , ItemTouchHelperAdapter {

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

    override fun onItemMove(fromPosition: Int, targetPosition: Int) {
        if (fromPosition < targetPosition) {
            for (i in fromPosition until targetPosition) { Collections.swap(items, i, i+1) }
        } else {
            for (i in targetPosition until fromPosition) { Collections.swap(items, i, i-1 ) }
        }
        notifyItemMoved(fromPosition, targetPosition);
    }

//    override fun onItemRemove(position: Int) {
//        TODO("Not yet implemented")
//    }
}