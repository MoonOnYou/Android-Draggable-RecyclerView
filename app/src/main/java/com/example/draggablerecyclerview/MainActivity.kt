package com.example.draggablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val data = mutableListOf<Model>()
    private val adapter = Adapter(data)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        setAdapter()
        setDraggable()
    }

    private fun initData() {
        for (i in 1..30) {
            val model = Model(i, "제목 $i", "내용 $i")
            data.add(model)
        }
    }

    private fun setAdapter() {
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    private fun setDraggable() {
        val callback = ItemMoveCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
    }
}