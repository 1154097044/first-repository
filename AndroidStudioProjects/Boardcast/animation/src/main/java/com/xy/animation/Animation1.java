package com.xy.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Animation1 extends AppCompatActivity {

    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation1);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过加载xml动画设置文件来创建一个Animation对象
                //透明度
//                Animation animation = AnimationUtils.loadAnimation(Animation1.this, R.anim.alpha);
//                iv.startAnimation(animation);
                //旋转
//                Animation animation = AnimationUtils.loadAnimation(Animation1.this, R.anim.rotate);
//                iv.startAnimation(animation);
                //缩放
//                Animation animation = AnimationUtils.loadAnimation(Animation1.this, R.anim.scale);
//                iv.startAnimation(animation);
                //平移
                Animation animation = AnimationUtils.loadAnimation(Animation1.this, R.anim.translate);
                iv.startAnimation(animation);
            }
        });
    }
}