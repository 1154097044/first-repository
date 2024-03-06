package com.xy.pluginpproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.xy.stander.ReceiverInterface;

// 能够接收的 广播接收者
public class ProxyReceiver extends BroadcastReceiver {

    // 插件里面的MyReceiver全类名
    private String pluginMyReceiverClassName;

    public ProxyReceiver(String pluginMyReceiverClassName){
        this.pluginMyReceiverClassName = pluginMyReceiverClassName;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // 加载插件里面的MyReceiver
        try {
            Class<?> mMyReceiverClass = PluginManager.getInstance(context).getClassLoader().loadClass(pluginMyReceiverClassName);
            // 实例化Class
            Object mMyReceiver = mMyReceiverClass.newInstance();
            ReceiverInterface receiverInterface = (ReceiverInterface) mMyReceiver;

            // 执行插件里面的MyReceiver onReceive方法

            receiverInterface.onReceive(context,intent);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
