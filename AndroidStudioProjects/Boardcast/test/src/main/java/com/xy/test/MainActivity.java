package com.xy.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.xy.test.adapter.OutAdapter;
import com.xy.test.beans.OutBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<OutBean> outBeans;
    private LinearLayoutManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        outBeans = new ArrayList<>();
        List<OutBean.InsideBean> tailBox = new ArrayList<>();
        tailBox.add(new OutBean.InsideBean("DM002284"));
        tailBox.add(new OutBean.InsideBean("DM002285"));
        outBeans.add(new OutBean("尾箱托",2,tailBox));
        List<OutBean.InsideBean> wholeTray = new ArrayList<>();
        wholeTray.add(new OutBean.InsideBean("整托1"));
        wholeTray.add(new OutBean.InsideBean("整托2"));
        wholeTray.add(new OutBean.InsideBean("整托3"));
        outBeans.add(new OutBean("整托",3,wholeTray));
        List<OutBean.InsideBean> wholeBox = new ArrayList<>();
        wholeBox.add(new OutBean.InsideBean("整箱托1"));
        wholeBox.add(new OutBean.InsideBean("整箱托2"));
        wholeBox.add(new OutBean.InsideBean("整箱托3"));
        wholeBox.add(new OutBean.InsideBean("整箱托4"));
        wholeBox.add(new OutBean.InsideBean("整箱托5"));
        wholeBox.add(new OutBean.InsideBean("整箱托6"));
        outBeans.add(new OutBean("整箱托",6,wholeBox));

        recycler.setAdapter(new OutAdapter(MainActivity.this,outBeans));
        recycler.setLayoutManager(manager);

    }

    private void initView() {
        recycler = findViewById(R.id.recycler);
        manager = new LinearLayoutManager(this);
//        btnFinish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                trayCodeTv.setText(Html.fromHtml( ImgSrc + getTrayCode(), getImageGetterInstance(),null));
//            }
//        });
    }
//
//    public Html.ImageGetter getImageGetterInstance(){
//        Html.ImageGetter imageGetter = new Html.ImageGetter() {
//            @Override
//            public Drawable getDrawable(String source) {
//                int id = Integer.parseInt(source);
//                Drawable d = getResources().getDrawable(id);
//                int wdp = dip2px(getBaseContext(),20);
//                int hdp = dip2px(getBaseContext(),20);
//                d.setBounds(0,0,wdp,hdp);
//                return d;
//            }
//        };
//        return imageGetter;
//    }
//    private String getTrayCode(){
//        if(trayCodeTv != null){
//            return trayCodeTv.getText().toString();
//        }
//        return null;
//    }
//
//    public static int dip2px(Context context,float dpValue){
//        final float scale = context.getResources().getDisplayMetrics().density;
//        return (int) (dpValue * scale + 0.5f);
//    }
}