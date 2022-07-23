package com.xy.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView currTray;
    private ImageView arrowIv;
    private TextView trayCode;
    private TextView newTray;
    private EditText scanTrayCode;
    private ScrollView scrollView;
    private LinearLayout tailBoxLl,tailBoxContentLl;
    private EditText tailBoxCode;
    private Button btnConfirm;
    private LinearLayout scanNewTrayLl;
    private int isFinish = 0;
    public static Intent getIntent(Context context,String code){
        Intent intent = new Intent(context,ItemDetailActivity.class);
        intent.putExtra("trayCode",code);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteam_detail);
        initView();
        initData();
    }

    private void initData() {
        String code = getIntent().getStringExtra("trayCode");
        String currTrayCode = getIntent().getStringExtra("currTrayCode");
        Log.d("itemDetailActivity",code);
        Log.d("itemDetailActivity",currTrayCode);
        if(!code.equals(currTrayCode)) {
            currTray.setText(currTrayCode);
            arrowIv.setVisibility(View.VISIBLE);
            scanNewTrayLl.setVisibility(View.GONE);
        }
        trayCode.setText(code);
        List<BoxDetail> list = new ArrayList<>();
        list.add(new BoxDetail("WX1",24));
        list.add(new BoxDetail("WX2",24));
        LayoutInflater inflater = LayoutInflater.from(this);
        if(list != null && list.size() > 0){
            for (BoxDetail b : list) {
                View itemView = inflater.inflate(R.layout.layout_tail_box, null);
                TextView containerCode = itemView.findViewById(R.id.containerCode_tv);
                TextView countTv = itemView.findViewById(R.id.count_tv);
                itemView.setTag(b);
                containerCode.setText(b.getBoxCode());
                countTv.setText(String.valueOf(b.getBoxCount()));
                tailBoxContentLl.addView(itemView);
                tailBoxLl.setVisibility(View.VISIBLE);
            }
        }
        btnConfirm.setOnClickListener(v -> {
            String tailCode = tailBoxCode.getText().toString();
            int childCount = tailBoxContentLl.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = tailBoxContentLl.getChildAt(i);
                if(view.getTag() == null){
                    return;
                }
                BoxDetail boxDetail = (BoxDetail) view.getTag();
                if(tailCode.equals(boxDetail.getBoxCode())){
                    TextView containerCode_tv = view.findViewById(R.id.containerCode_tv);
                    TextView count_tv = view.findViewById(R.id.count_tv);
                    Drawable drawable = getResources().getDrawable(R.drawable.icon_check_mark);
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                    containerCode_tv.setCompoundDrawables(drawable,null,null,null);
                    containerCode_tv.setTextColor(getResources().getColor(R.color.edit_text));
                    count_tv.setTextColor(getResources().getColor(R.color.edit_text));
                    isFinish++;
                    break;
                }
            }
            if(isFinish == childCount){
//                Intent intent = new Intent();
//                intent.putExtra("finish","finish");
//                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void initView() {
        currTray = findViewById(R.id.curr_tray);
        arrowIv = findViewById(R.id.arrow_iv);
        trayCode = findViewById(R.id.tray_code);
        newTray = findViewById(R.id.new_tray);
        scanTrayCode = findViewById(R.id.scan_new_tray);
        scrollView = findViewById(R.id.scrollView);
        tailBoxLl = findViewById(R.id.tailBox_ll);
        tailBoxContentLl = findViewById(R.id.tailBoxContent_ll);
        tailBoxCode = findViewById(R.id.tail_box_code);
        btnConfirm = findViewById(R.id.btn_confirm);
        scanNewTrayLl = findViewById(R.id.scan_new_tray_ll);
    }
}