package com.example.draggablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val data = mutableListOf<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        setAdapter()
    }

    private fun initData() {
        for (i in 1..30) {
            val model = Model(i, "제목 $i", "내용 $i")
            data.add(model)
        }
    }

    private fun setAdapter() {
        val manager = LinearLayoutManager(this)
        val adapter = Adapter(data)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}