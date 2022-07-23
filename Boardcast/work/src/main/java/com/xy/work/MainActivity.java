package com.xy.work;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Instrumentation;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Model> list = new ArrayList<>();
    private Button btnFinish;

    public static Intent getIntent(Context context, String trayCode) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("trayCode", trayCode);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        if (list.isEmpty()) {
            list.add(new Model(Model.TITLE, 2, "尾箱托:", null));
            list.add(new Model(Model.DETAIL, 0, "DM0022084", "尾箱托"));
            list.add(new Model(Model.DETAIL, 0, "DM0022085", "尾箱托"));
            list.add(new Model(Model.TITLE, 4, "整托:", null));
            list.add(new Model(Model.DETAIL, 0, "整托1", "整托"));
            list.add(new Model(Model.DETAIL, 0, "整托2", "整托"));
            list.add(new Model(Model.DETAIL, 0, "整托3", "整托"));
            list.add(new Model(Model.DETAIL, 0, "整托4", "整托"));
            list.add(new Model(Model.TITLE, 6, "整箱托:", null));
            list.add(new Model(Model.DETAIL, 0, "整箱托1", "整箱托"));
            list.add(new Model(Model.DETAIL, 0, "整箱托2", "整箱托"));
            list.add(new Model(Model.DETAIL, 0, "整箱托3", "整箱托"));
            list.add(new Model(Model.DETAIL, 0, "整箱托4", "整箱托"));
            list.add(new Model(Model.DETAIL, 0, "整箱托5", "整箱托"));
            list.add(new Model(Model.DETAIL, 0, "整箱托6", "整箱托"));
        }
        if (getIntent().getBooleanExtra("finish", false)) {
            String trayCode = getIntent().getStringExtra("trayCode");
            removeTray(trayCode);
        }

        refreshList();
        btnFinish.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setIcon(R.drawable.finish);
            builder.setTitle("是否完成本次整零拆分");
            builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycle_view);
        btnFinish = findViewById(R.id.btn_finish);
    }


    private void removeTray(String removeCode) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(removeCode)) {
                String trayType = list.get(i).getTrayType();
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getText().equals(trayType)) {

                    }
                }
                list.remove(i);
            }
        }
    }

    private void refreshList() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        MyAdapter adapters = new MyAdapter(this, list, this);
        recyclerView.setAdapter(adapters);
        recyclerView.setLayoutManager(manager);
    }
}