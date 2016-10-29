package com.example.kirito.testrecyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DemoAdapter adpter;

    private int colors[] = {android.R.color.holo_blue_bright,android.R.color.black,android.R.color.holo_red_dark};
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //gridlayoutmanager构造参数里的2，指的是一行有几列
        final GridLayoutManager manager = new GridLayoutManager(this,2);
        //必须设置layoutmanager，否则无法正常加载
        recyclerView.setLayoutManager(manager);
        adpter = new DemoAdapter(this);
        initData();
        recyclerView.setAdapter(adpter);
        //设置占用的列数
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = recyclerView.getAdapter().getItemViewType(position);
                //若是TYPE_THREE，占用两列，否则占用一列
                if (type == Item.TYPE_THREE){
                    return manager.getSpanCount();
                }else {
                    return 1;
                }
            }
        });
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                //给布局里的子view添加边距
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != manager.getSpanCount()){
                    if (spanIndex == 0){
                        outRect.right = 10;
                    }else {
                        outRect.left = 10;
                    }
                }
            }
        });
    }

    private void initData() {
        /*List<Item> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            //产生1-3的随机数
            int type = (int) (Math.random() * 3 + 1);
            //Log.e(TAG, "initData: random---"+ (int) (Math.random() * 3 + 1));
            item.type = type;
            item.avaterColor = colors[type - 1];
            item.content = "content:" + type;
            item.contentColor = colors[type - 1];
            item.name = "name:" + type;
            items.add(item);
        }
        adpter.addList(items);
        //即使不要下面这句也能正常初始化recyclerview
        adpter.notifyDataSetChanged();*/

        List<ItemOne> itemOnes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemOne itemOne = new ItemOne();

            itemOne.avaterColor = colors[0];
            itemOne.name = "name:" + 1;
            itemOnes.add(itemOne);
        }

        List<ItemTwo> itemTwos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemTwo itemTwo = new ItemTwo();

            itemTwo.avaterColor = colors[1];
            itemTwo.name = "name:" + 2;
            itemTwo.content = "content:" + 2;
            itemTwos.add(itemTwo);
        }

        List<ItemThree> itemThrees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemThree itemThree = new ItemThree();

            itemThree.avaterColor = colors[2];
            itemThree.name = "name:" + 3;
            itemThree.content = "content:" + 3;
            itemThree.contentColor = colors[2];
            itemThrees.add(itemThree);
        }

        adpter.addList(itemOnes,itemTwos,itemThrees);
        adpter.notifyDataSetChanged();
    }


}
