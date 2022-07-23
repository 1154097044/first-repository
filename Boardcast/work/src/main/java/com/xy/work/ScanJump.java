package com.xy.work;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class ScanJump extends AppCompatActivity {

    private TextView waitTrayCode;
    private ImageView ivBack;
    private Button scanFinish;
    private String trayCode;
    private EditText scanTrayCode;
    private ActivityResultLauncher requestDataLauncher;
    public static Intent getIntent(Context context, String trayCode) {
        Intent intent = new Intent(context, ScanJump.class);
        intent.putExtra("trayCode", trayCode);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_jump);
        initView();
        initData();
    }

    private void initData() {
        trayCode = getIntent().getStringExtra("trayCode");
        Log.d("ScanJump", trayCode);

        waitTrayCode.setText(trayCode);
        ivBack.setOnClickListener(v -> {
            finish();
        });
        scanFinish.setOnClickListener(v -> {
            String scanCode = scanTrayCode.getText().toString();
            if (scanCode.length() > 0) {
                Intent intent = ItemDetailActivity.getIntent(ScanJump.this, scanCode);
                intent.putExtra("currTrayCode", trayCode);
//                requestDataLauncher.launch(intent);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "托盘好不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

    private void initView() {
        waitTrayCode = findViewById(R.id.wait_tray_code);
        ivBack = findViewById(R.id.iv_back);
        scanFinish = findViewById(R.id.scan_finish);
        scanTrayCode = findViewById(R.id.sca_tray_code);
//        requestDataLauncher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),result -> {
//                    String isFinish = result.getData().getStringExtra("finish");
//                    Log.d("ScanJump",isFinish);
//                    if(isFinish.equals("finish")){
//                        finish();
//                    }
//        });
    }


}