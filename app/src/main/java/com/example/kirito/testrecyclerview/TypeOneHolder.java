package com.example.kirito.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kirito on 2016.10.29.
 */

public class TypeOneHolder extends TypeAbstarctViewHolder<ItemOne> {
    private ImageView avater;
    private TextView name;

    public TypeOneHolder(View itemView) {
        super(itemView);
        avater = (ImageView) itemView.findViewById(R.id.avater);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    //为ViewHolder绑定数据
    @Override
    public void bindHolder(ItemOne item) {
        avater.setBackgroundResource(item.avaterColor);
        name.setText(item.name);
    }
}
