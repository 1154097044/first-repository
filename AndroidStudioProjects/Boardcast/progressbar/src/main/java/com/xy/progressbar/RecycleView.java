package com.xy.progressbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.xy.progressbar.adapter.MyAdapter;
import com.xy.progressbar.bean.Bean;

import java.util.ArrayList;

public class RecycleView extends AppCompatActivity {

    private RecyclerView recycler;
    private ArrayList<Bean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        recycler = findViewById(R.id.recycler);
        list = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            Bean bean = new Bean();
            bean.setData(i);
            bean.setContent("项目" + i);
            list.add(bean);
        }

        MyAdapter adapters = new MyAdapter(this,list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setAdapter(adapters);
        recycler.setLayoutManager(manager);
    }
}