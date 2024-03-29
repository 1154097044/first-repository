package com.xy.pluginpproject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.xy.stander.ActivityInterface;

import java.lang.reflect.Constructor;

// 代理的Activity 代理占位 插件里面的
public class ProxyActivity extends Activity {

    @Override
    public Resources getResources() {
        return PluginManager.getInstance(this).getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance(this).getClassLoader();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 真正的加载 插件里面的Activity
        String className = getIntent().getStringExtra("className");

        try {
            Class<?> mPluginActivityClass = getClassLoader().loadClass(className);
            // 实例化 插件包里面的Activity
            Constructor constructor = mPluginActivityClass.getConstructor(new Class[]{});
            Object mPluginActivity = constructor.newInstance(new Object[]{});

            ActivityInterface activityInterface = (ActivityInterface) mPluginActivity;

            // 注入
            activityInterface.insertAppContext(this);

            Bundle bundle = new Bundle();
            bundle.putString("appName","我是宿主传递过来的信息");
            // 执行插件里面的onCreate方法
            activityInterface.onCreate(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startActivity(Intent intent) {
        String className = intent.getStringExtra("className");

        Intent proxyIntent = new Intent(this, ProxyActivity.class);
        proxyIntent.putExtra("className",className);
        // 要给TestActivity 进栈
        super.startActivity(proxyIntent);
    }

    @Override
    public ComponentName startService(Intent service) {
        String className = service.getStringExtra("className");

        Intent intent = new Intent(this,ProxyService.class);
        intent.putExtra("className",className);
        return super.startService(intent);
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        String pluginMyReceiverClassName = receiver.getClass().getName();
        // 在宿主 注册广播
        return super.registerReceiver(new ProxyReceiver(pluginMyReceiverClassName), filter);
    }

    @Override
    public void sendBroadcast(Intent intent) {
        super.sendBroadcast(intent); // 发送
    }
}