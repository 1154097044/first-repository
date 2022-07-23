package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    private boolean isShift = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_text);
        editText = findViewById(R.id.edit_text);
        button.setOnClickListener(this);
        imageView = findViewById(R.id.iv_view);
        progressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_text:
//                if(progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else{
//                    progressBar.setVisibility(View.GONE);
//                }
//                if(isShift){
//                    imageView.setImageResource(R.drawable.coke);
//                    isShift = false;
//                }
//                else{
//                    imageView.setImageResource(R.drawable.coffee);
//                    isShift = true;
//                }
//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress((progress));

                //AlertDialog的用法
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("This is Dialog");
//                dialog.setMessage("Something important.");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                dialog.show();

                //ProgressDialog的用法
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}