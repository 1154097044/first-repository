package com.xy.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContainerDivide extends AppCompatActivity {

    private TextView currentCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_container_divide);
        currentCode = findViewById(R.id.current_code);
        String code = getIntent().getStringExtra("tray_code");
        currentCode.setText(code);
    }

}