package com.xy.plugin_packages;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;

import com.xy.stander.ActivityInterface;

public class BaseActivity extends Activity implements ActivityInterface {

    public Activity appActivity; // 宿主的环境

    @Override
    public void insertAppContext(Activity appActivity) {
        this.appActivity = appActivity;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStart() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onDestroy() {

    }

    public void setContentView(int resId) {
        appActivity.setContentView(resId);
    }

    public <T extends View> T findViewById(@IdRes int id) {
        return appActivity.findViewById(id);
    }

    @Override
    public void startActivity(Intent intent){
        Intent intentNew = new Intent();
        intentNew.putExtra("className",intent.getComponent().getClassName()); // TestActivity 全类名
        appActivity.startActivity(intentNew);
    }

    @Override
    public ComponentName startService(Intent service) {
        Intent intentNew = new Intent();
        intentNew.putExtra("className",service.getComponent().getClassName()); // TestService 全类名
        return appActivity.startService(intentNew);
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return appActivity.registerReceiver(receiver,filter);
    }

    @Override
    public void sendBroadcast(Intent intent) {
        appActivity.sendBroadcast(intent);
    }
}
