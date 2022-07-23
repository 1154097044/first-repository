package com.xy.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

public class BlankFragment1 extends Fragment {

    private View root;
    private TextView textView;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(root == null) {
            root = inflater.inflate(R.layout.fragment_blank1, container, false);
        }
        textView = root.findViewById(R.id.text_view);
        button = root.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textView.setText("Yes,I am,and you?");

            }
        });
        return root;
    }
}