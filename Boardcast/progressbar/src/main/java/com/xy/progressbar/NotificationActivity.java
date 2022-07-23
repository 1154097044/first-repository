package com.xy.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Log.d("leo","onCreate:进入NotificationActivity");
        Toast.makeText(this,"进入NotificationActivity",Toast.LENGTH_SHORT).show();
    }
}