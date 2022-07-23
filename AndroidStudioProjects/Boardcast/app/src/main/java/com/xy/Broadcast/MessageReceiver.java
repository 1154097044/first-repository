package com.xy.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MessageReceiver extends BroadcastReceiver {

    private static final String TAG = "MessageReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG,"action is --> " + action);
        String content = intent.getStringExtra(Constants.KEY_CONTENT);
        Log.d(TAG,"content is --> " + content);
    }
}
