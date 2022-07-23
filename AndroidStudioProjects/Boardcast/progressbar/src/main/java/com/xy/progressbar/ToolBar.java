package com.xy.progressbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class ToolBar extends AppCompatActivity {

    private static final String TAG = "ToolBar";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.tb2);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:ToolBar被点击了");
                Toast.makeText(getBaseContext(),"ToolBar被点击了",Toast.LENGTH_SHORT).show();
            }
        });
        toolbar2.setNavigationIcon(R.drawable.content);
        toolbar2.setTitle("标题");
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:ToolBar2被点击了");
                Toast.makeText(getBaseContext(),"ToolBar2被点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }
}