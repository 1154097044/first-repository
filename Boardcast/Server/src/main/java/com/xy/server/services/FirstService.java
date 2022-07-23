package com.xy.server.services;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.xy.server.interfaces.ICommunication;

public class FirstService extends Service {

    private static final String TAG = FirstService.class.getName();

    private class InnerBinder extends Binder implements ICommunication {
        @Override
        public void callServiceInnerMethod() {
            sayHello();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind");
        return new InnerBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate...");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d(TAG,"onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    private void sayHello(){
        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Hello");
    }
}
