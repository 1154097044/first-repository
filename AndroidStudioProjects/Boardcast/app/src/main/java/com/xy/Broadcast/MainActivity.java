package com.xy.Broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private BatteryLevelReceiver batteryLevelReceiver;
    private TextView batteryLevel;
    private TextView batteryPercent;
    private TextView usbStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        registerBatteryReceiver();
    }

    private void initView() {
        batteryLevel = (TextView) findViewById(R.id.battery_level);
        batteryPercent = (TextView) findViewById(R.id.battery_percent);
        usbStatus = (TextView) findViewById(R.id.usb_status);
    }


    private void registerBatteryReceiver(){
        //第二步
        //我们要收听的频道：电量变化
        IntentFilter intentFilter = new IntentFilter();

        //第三步
        //设置频道
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        //第四步
        batteryLevelReceiver = new BatteryLevelReceiver();

        //第五步
        //注册广播
        //这种方式是动态注册
        this.registerReceiver(batteryLevelReceiver,intentFilter);
    }
    /**
     *  第一步，就是创建一个广播接收者，继承自BroadcastReceiver
     */
    private class BatteryLevelReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action){
                case Intent.ACTION_BATTERY_CHANGED:
                    int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                    Log.d(TAG,"收到了电量变化的广播 - action is = " + action);
                    Log.d(TAG,"当前电量：" + currentLevel);
                    if(batteryLevel != null){
                        batteryLevel.setText("目前电量:" + currentLevel);
                    }
                    int maxLevel = intent.getIntExtra(BatteryManager.EXTRA_SCALE,0);

                    //拿到当前的电量以后，再除以最大值
                    float percent = currentLevel * 1.0f / maxLevel;
                    Log.d(TAG,"当前电量百分比是：" + percent * 100 + "%");
                    if(batteryPercent != null){
                        batteryPercent.setText("目前电量百分比:" + percent * 100 + "%");
                    }
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    Log.d(TAG,"usb线连接上了");
                    if(usbStatus != null){
                        usbStatus.setText("usb线连接上了");
                    }
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    Log.d(TAG,"usb线断开了");
                    if(usbStatus != null){
                        usbStatus.setText("usb线断开了");
                    }
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消广播注册，否则会导致内存泄漏
        if(batteryLevelReceiver != null){
            this.unregisterReceiver(batteryLevelReceiver);
            batteryLevelReceiver = null;
        }
    }
}