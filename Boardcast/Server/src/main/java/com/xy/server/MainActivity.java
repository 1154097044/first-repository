package com.xy.server;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.xy.server.interfaces.ICommunication;
import com.xy.server.services.FirstService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private boolean bindService;
    private ICommunication innerBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate...");

    }

    /**
     * 开启服务
     */
    public void startServiceClick(View view){
        Intent intent = new Intent();
        intent.setClass(this, FirstService.class);
        startService(intent);
    }

    /**
     * 停止服务
     */
    public void stopServiceClick(View view){
        Intent intent = new Intent();
        intent.setClass(this,FirstService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy...");
    }

    public void callServiceMethod(View view){
        Log.d(TAG,"callServiceMethod");
        innerBinder.callServiceInnerMethod();
    }

    /**
     * 绑定服务
     */
    public void bindServiceClick(View view){
        Intent intent = new Intent();
        intent.setClass(this,FirstService.class);
        bindService = bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG,"onServiceConnected");
            innerBinder = (ICommunication) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG,"onServiceDisconnected");
            innerBinder = null;
        }
    };

    /**
     * 解绑服务
     */
    public void unbindServiceClick(View view){
        if(mConnection != null && bindService) {
            unbindService(mConnection);
        }
    }
}