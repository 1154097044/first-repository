package com.xy.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xy.linearlayout.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tailTrayCount;
    private TextView wholeTrayCount;
    private TextView wholeTrayBoxCount;
    private LinearLayout tailTrayCodeLl;
    private LinearLayout wholeTrayCodeLl;
    private LinearLayout wholeTrayBoxCodeLl;
    private List<BaseBean> tailBox;
    private List<BaseBean> wholeTray;
    private List<BaseBean> wholeBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        tailBox.add(new BaseBean(BaseBean.TAIL_BOX,"DM01"));
        tailBox.add(new BaseBean(BaseBean.TAIL_BOX,"DM02"));
        tailBox.add(new BaseBean(BaseBean.TAIL_BOX,"DM03"));
        wholeTray.add(new BaseBean(BaseBean.WHOLE_TRAY,"ZT01"));
        wholeTray.add(new BaseBean(BaseBean.WHOLE_TRAY,"ZT02"));
        wholeTray.add(new BaseBean(BaseBean.WHOLE_TRAY,"ZT03"));
        wholeTray.add(new BaseBean(BaseBean.WHOLE_TRAY,"ZT04"));
        wholeTray.add(new BaseBean(BaseBean.WHOLE_TRAY,"ZT05"));
        wholeTray.add(new BaseBean(BaseBean.WHOLE_TRAY,"ZT06"));
        wholeTray.add(new BaseBean(BaseBean.WHOLE_TRAY,"ZT07"));
        wholeBox.add(new BaseBean(BaseBean.WHOLE_BOX,"ZXT01"));
        wholeBox.add(new BaseBean(BaseBean.WHOLE_BOX,"ZXT02"));
        wholeBox.add(new BaseBean(BaseBean.WHOLE_BOX,"ZXT03"));
        wholeBox.add(new BaseBean(BaseBean.WHOLE_BOX,"ZXT04"));
        wholeBox.add(new BaseBean(BaseBean.WHOLE_BOX,"ZXT05"));
        wholeBox.add(new BaseBean(BaseBean.WHOLE_BOX,"ZXT06"));
        wholeBox.add(new BaseBean(BaseBean.WHOLE_BOX,"ZXT07"));
        tailTrayCount.setText(String.valueOf(tailBox.size()));
        wholeTrayCount.setText(String.valueOf(wholeTray.size()));
        wholeTrayBoxCount.setText(String.valueOf(wholeBox.size()));
        LayoutInflater inflater = LayoutInflater.from(this);
        for (BaseBean b : tailBox) {
            View view = inflater.inflate(R.layout.layout_item_detail,null);
            TextView trayCodeTv = view.findViewById(R.id.tray_code_tv);
            view.setTag(b);
            trayCodeTv.setText(b.getTrayCode());
            tailTrayCodeLl.addView(view);
        }
        for (BaseBean b : wholeTray) {
            View view = inflater.inflate(R.layout.layout_item_detail,null);
            TextView trayCodeTv = view.findViewById(R.id.tray_code_tv);
            view.setTag(b);
            trayCodeTv.setText(b.getTrayCode());
            wholeTrayCodeLl.addView(view);
        }
        for (BaseBean b : wholeBox) {
            View view = inflater.inflate(R.layout.layout_item_detail,null);
            TextView trayCodeTv = view.findViewById(R.id.tray_code_tv);
            view.setTag(b);
            trayCodeTv.setText(b.getTrayCode());
            wholeTrayBoxCodeLl.addView(view);
        }
    }

    private void initView() {
        tailTrayCount = findViewById(R.id.tail_tray_count);
        wholeTrayBoxCount = findViewById(R.id.whole_box_tray_count);
        wholeTrayCount = findViewById(R.id.whole_tray_count);
        tailTrayCodeLl = findViewById(R.id.tail_tray_code);
        wholeTrayCodeLl = findViewById(R.id.whole_tray_code);
        wholeTrayBoxCodeLl = findViewById(R.id.whole_box_tray_code);
        tailBox = new ArrayList<>();
        wholeTray = new ArrayList<>();
        wholeBox = new ArrayList<>();
    }
}