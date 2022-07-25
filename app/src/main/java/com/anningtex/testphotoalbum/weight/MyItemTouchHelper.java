package com.anningtex.testphotoalbum.weight;

import android.util.Log;
import android.view.animation.ScaleAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.syp.library.BaseRecycleAdapter;

/**
 * @author Song
 * desc: Recycle 拖拽
 */
public class MyItemTouchHelper extends ItemTouchHelper.Callback {
    private BaseRecycleAdapter mAdapter;
    private OnRefreshListener mOnRefreshListener;

    public MyItemTouchHelper(BaseRecycleAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlag;
        int swipeFlag;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP
                    | ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
            swipeFlag = 0;
        } else {
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
            swipeFlag = ItemTouchHelper.END;
        }
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
        Log.e("测试", "onMove: fromPosition = " + fromPosition + " toPosition = " + toPosition);
        if (mOnRefreshListener != null) {
            mOnRefreshListener.onRefresh(fromPosition, toPosition);
        }
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        if (direction == ItemTouchHelper.END) {
            mAdapter.getData().remove(position);
            mAdapter.notifyItemRemoved(position);
            Log.e("测试", "onSwiped: position = " + position);
        }
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.2f, 1f, 1.2f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setFillAfter(true);
            viewHolder.itemView.startAnimation(scaleAnimation);
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1f, 1f, 1f);
        scaleAnimation.setDuration(0);
        scaleAnimation.setFillAfter(true);
        viewHolder.itemView.startAnimation(scaleAnimation);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        mOnRefreshListener = onRefreshListener;
    }

    public interface OnRefreshListener {
        void onRefresh(int fromPosition, int toPosition);
    }
}
