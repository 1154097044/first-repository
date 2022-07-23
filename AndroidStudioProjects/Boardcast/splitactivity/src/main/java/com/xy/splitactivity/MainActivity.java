package com.xy.splitactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xy.splitactivity.adapter.MyAdapter;
import com.xy.splitactivity.model.FullPalletDTO;
import com.xy.splitactivity.model.PartialPalletWithFclDT;
import com.xy.splitactivity.model.PartialPalletWithLclDTO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private Button btnFinish;
    private List<PartialPalletWithLclDTO> partialPalletWithLclDTOS;
    private List<PartialPalletWithFclDT> partialPalletWithFclDTS;
    private List<FullPalletDTO> fullPalletDTOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        recycler = findViewById(R.id.recycle_view);
        btnFinish = findViewById(R.id.btn_finish);
        partialPalletWithLclDTOS = new ArrayList<>();
        partialPalletWithFclDTS = new ArrayList<>();
        fullPalletDTOS = new ArrayList<>();
        partialPalletWithLclDTOS.add(new PartialPalletWithLclDTO("1","1","DM01"));
        partialPalletWithFclDTS.add(new PartialPalletWithFclDT("2","2","WT01"));
        partialPalletWithFclDTS.add(new PartialPalletWithFclDT("2","2","WT02"));
        partialPalletWithFclDTS.add(new PartialPalletWithFclDT("2","2","WT03"));
        partialPalletWithFclDTS.add(new PartialPalletWithFclDT("2","2","WT04"));
        partialPalletWithFclDTS.add(new PartialPalletWithFclDT("2","2","WT05"));
        partialPalletWithFclDTS.add(new PartialPalletWithFclDT("2","2","WT06"));
        fullPalletDTOS.add(new FullPalletDTO("3","3"));
        fullPalletDTOS.add(new FullPalletDTO("3","3"));
        fullPalletDTOS.add(new FullPalletDTO("3","3"));
        fullPalletDTOS.add(new FullPalletDTO("3","3"));
        fullPalletDTOS.add(new FullPalletDTO("3","3"));
    }


}