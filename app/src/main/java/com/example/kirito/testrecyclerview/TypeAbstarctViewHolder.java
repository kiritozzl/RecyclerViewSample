package com.example.kirito.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kirito on 2016.10.29.
 */

//<T>使用了泛型
public abstract class TypeAbstarctViewHolder<T> extends RecyclerView.ViewHolder {
    public TypeAbstarctViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T item);
}
