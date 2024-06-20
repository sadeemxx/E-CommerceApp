package com.example.e_commerceapp.utils

import android.graphics.Rect
import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RightSpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    @Override
    override fun getItemOffsets(@NonNull outRect: Rect, @NonNull view: View, @NonNull parent: RecyclerView, @NonNull state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state);

        val spanCount = getSpanCount(parent)
        val position = parent.getChildAdapterPosition(view)

        // Check for valid position and last item in a row
        if (position != RecyclerView.NO_POSITION && isLastItemInRow(spanCount, position)) {
            outRect.top = space
        }
    }

    private fun getSpanCount(parent: RecyclerView): Int {
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            return (layoutManager as GridLayoutManager).spanCount
        } else {
            return 1 // Default to 1 for non-GridLayoutManager cases
        }
    }

    private fun isLastItemInRow(spanCount: Int, position: Int): Boolean {
        val remainder = position % spanCount
        return remainder == spanCount - 1
    }
}
