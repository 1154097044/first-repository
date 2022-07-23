package com.xy.work;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyDialog extends AlertDialog implements View.OnClickListener{

    private Button btnBack;
    private Button btnContinue;
    private Context mContext;
    private Activity mActivity;

    public MyDialog(Context context,Activity activity){
        super(context);
        this.mContext = context;
        this.mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);
        initView();
        initData();
    }

    private void initData() {
        btnBack.setOnClickListener(this);
        btnContinue.setOnClickListener(this);
    }

    private void initView() {
        btnBack = findViewById(R.id.btn_back);
        btnContinue = findViewById(R.id.btn_continue);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                this.dismiss();
                String trayCode = mActivity.getIntent().getStringExtra("trayCode");
                Log.d("back",trayCode);
                Intent intent = MainActivity.getIntent(mContext,trayCode);
                mActivity.startActivity(intent);
                break;
            case R.id.btn_continue:
                this.dismiss();
                break;
            default:
                break;
        }
    }
}
