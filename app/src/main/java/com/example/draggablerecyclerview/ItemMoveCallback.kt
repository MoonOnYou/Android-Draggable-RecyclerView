package com.example.draggablerecyclerview

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


class ItemMoveCallback(val helperAdapter : ItemTouchHelperAdapter) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
//        val flagDrag = ItemTouchHelper.START or ItemTouchHelper.END
//        val flagSwipe = ItemTouchHelper.UP or ItemTouchHelper.DOWN

        val flagDrag = ItemTouchHelper.UP or ItemTouchHelper.DOWN //item drag
        val flagSwipe = ItemTouchHelper.START or ItemTouchHelper.END //item swipe

        //return makeMovementFlags(flagDrag, flagSwipe); //drag & swipe 사용
         return makeMovementFlags(flagDrag, 0); //swipe 액션 중지
        // return makeMovementFlags(0, flagSwipe); //drag 액션 중지

    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        helperAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//        helperInterface.onItemRemove(viewHolder.adapterPosition)
    }

    override fun isLongPressDragEnabled(): Boolean {
        return true   // 롱 터치 입력 허용
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return false  // swipe 사용하려면 true
    }
}

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition : Int, targetPosition : Int)
//    fun onItemRemove(position : Int)
}