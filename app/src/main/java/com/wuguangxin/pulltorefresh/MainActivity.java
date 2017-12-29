package com.wuguangxin.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.SimpleAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private PullToRefreshListView listView;
    private List<Map<String, Object>> data;
    private int count = 100;
    private SimpleAdapter adapter;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (PullToRefreshListView) findViewById(R.id.listView);
        View divider = new View(this);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -1);
        layoutParams.height = 1;
        divider.setLayoutParams(layoutParams);

        divider.setBackgroundColor(R.color.background);
        listView.getRefreshableView().addHeaderView(divider);
        listView.getRefreshableView().addFooterView(divider);

        initData();
        adapter = new SimpleAdapter(this, data,
                R.layout.item_list,
                new String[]{"name","phone"},
                new int[]{R.id.name, R.id.phone});
        listView.setAdapter(adapter);


        findViewById(R.id.pullToRefreshScrollView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PullToRefreshScrollViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("name", i+1);
            map.put("phone", 18600000000L + i);
            data.add(map);
        }
    }
}
