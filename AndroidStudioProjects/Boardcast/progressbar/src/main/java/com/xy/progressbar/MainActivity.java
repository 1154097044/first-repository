package com.xy.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private ProgressBar pb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.pb);
        pb1 =findViewById(R.id.pb1);
    }

    public void leoClick(View view){
        if(pb.getVisibility() == View.GONE){
            pb.setVisibility(View.VISIBLE);
        }else{
            pb.setVisibility(View.GONE);
        }
    }

    public void load(View view){
        int progress = pb1.getProgress();
        progress +=10;
        pb1.setProgress(progress);
    }
}