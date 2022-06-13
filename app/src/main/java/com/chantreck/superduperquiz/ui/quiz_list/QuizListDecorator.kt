package com.chantreck.superduperquiz.ui.quiz_list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.chantreck.superduperquiz.R

class QuizListDecorator : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        val margin = parent.context.resources.getDimensionPixelOffset(R.dimen.margin_16)
        val adapter = parent.adapter ?: return

        outRect.top = margin

        val position = parent.getChildAdapterPosition(view)
        if (position == adapter.itemCount - 1) {
            outRect.bottom = margin
        }
    }
}