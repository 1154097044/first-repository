package com.xy.pluginpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        PluginManager.getInstance(this).unregisterBroadcast();
        super.onDestroy();
    }


    // 加载插件
    public void loadPlugin(View view) {
        PluginManager.getInstance(this).loadPlugin();
    }

    // 启动插件Activity
    public void startPluginActivity(View view) {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "Android/data/p.apk");
        String path = file.getAbsolutePath();

        // 获取插件包 里面的Activity
        PackageManager packageManager = getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        ActivityInfo activityInfo = packageInfo.activities[0];

        // 占位 代理Activity
        Intent intent = new Intent(this,ProxyActivity.class);
        intent.putExtra("className",activityInfo.name);
        startActivity(intent);
    }

    // 注册插件 配置的静态广播接收者
    public void loadStaticReceiver(View view) {
        PluginManager.getInstance(this).parserApkAction();
    }

    public void sendStaticReceiver(View view) {
        Intent intent = new Intent();
        intent.setAction("plugin.static_receiver");
        sendBroadcast(intent);
    }



}