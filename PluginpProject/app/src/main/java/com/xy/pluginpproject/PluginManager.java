package com.xy.pluginpproject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import dalvik.system.DexClassLoader;

public class PluginManager {

    private static final String TAG = "PluginManager";

    private static PluginManager pluginManager;

    private Context context;

    public static PluginManager getInstance(Context context) {
        if (pluginManager == null) {
            synchronized (PluginManager.class) {
                if (pluginManager == null) {
                    pluginManager = new PluginManager(context);
                }
            }
        }
        return pluginManager;
    }

    public PluginManager(Context context) {
        this.context = context;
    }

    private DexClassLoader dexClassLoader;
    private Resources resources;

    private ArrayList<BroadcastReceiver> broadcastReceivers = new ArrayList<>();

    /**
     * （2.1 Activity.class ，2.2 layout）
     * 加载插件
     */
    public void loadPlugin() {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "Android/data/p.apk");
            if (!file.exists()) {
                Log.e(TAG, "插件包不存在");
                return;
            }
            // 插件路径
            String pluginPath = file.getAbsolutePath();
            Log.e(TAG, "ExternalStorageDirectory = " + Environment.getExternalStorageDirectory());
            Log.e(TAG, "File.separator = " + File.separator);
            Log.e(TAG, "pluginPath = " + pluginPath);


            // dexClassLoader 需要一个缓存目录 /data/data/当前应用的包名/pDir
            File fileDir = context.getDir("pDir", Context.MODE_PRIVATE);

            Log.e(TAG, "fileDirPath = " + fileDir.getAbsolutePath());
            // Activity class
            dexClassLoader = new DexClassLoader(pluginPath, fileDir.getAbsolutePath(), null, context.getClassLoader());

            /**
             * 下面是加载插件里面的layout
             */
            // 加载资源
            AssetManager assetManager = AssetManager.class.newInstance();

            /**
             * 我们要执行此方法，为了把插件包的路径 添加进去
             * public final int addAssetPath(String path)
             */
            Method addAssetPathMethod = assetManager.getClass().getMethod("addAssetPath", String.class);// 他是类类型Class
            addAssetPathMethod.invoke(assetManager, pluginPath); // 插件包路径 pluginPath

            Resources r = context.getResources();// 宿主的资源配置信息
            this.resources = new Resources(assetManager, r.getDisplayMetrics(), r.getConfiguration());//参数2 3 资源的配置信息

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClassLoader getClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }


    // 反射系统源码，来解析 apk 文件里面的所有信息
    public void parserApkAction() {
        try {
            // 插件包路径
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "Android/data/p.apk");
            if (!file.exists()) {
                Log.e(TAG, "插件包不存在");
                return;
            }
            // 插件路径
            String pluginPath = file.getAbsolutePath();

            // 实例化 PackageParser对象
            Class<?> mPackageParserClass = Class.forName("android.content.pm.PackageParser");
            Object mPackageParser = mPackageParserClass.newInstance();


            // 执行此方法public Package parsePackage(File packageFile,int flags),就是为了，拿到Package
            Method mPackageParserMethod = mPackageParserClass.getMethod("parsePackage", File.class, int.class);// 类类型
            Object mPackage = mPackageParserMethod.invoke(mPackageParser, file, PackageManager.GET_ACTIVITIES);// 执行方法

            // 继续分析 Package
            // 得到 receiver
            Field receiversField = mPackage.getClass().getDeclaredField("receivers");
            // receivers 本质就是 ArrayList 集合
            Object receivers = receiversField.get(mPackage);

            ArrayList arrayList = (ArrayList) receivers;

            // 此Activity 不是组件的Activity，是PackageParser里面的内容类

            for (Object mActivity : arrayList) { // mActivity --> <receiver android:name=".StaticReceiver">

                // 获取<intent-filer> intents == 很多intent-filer
                // 通过反射拿到intents
                Class<?> mComponentClass = Class.forName("android.content.pm.PackageParser$Component");
                Field intentsField = mComponentClass.getDeclaredField("intents");
                ArrayList<IntentFilter> intents = (ArrayList) intentsField.get(mActivity); // intents 所属的对象是谁

                // 我们还有一个任务，就是拿到android:name=".StaticReceiver"
                // activityInfo.name; == android.name=".StaticReceiver"
                // 分析源码 如何 拿到 ActivityInfo

                Class<?> mPackageUserState = Class.forName("android.content.pm.PackageUserState");
                Class<?> mUserHandle = Class.forName("android.os.UserHandle");
                int userId = (int) mUserHandle.getMethod("getCallingUserId").invoke(null);
                /**
                 * 执行此方法，就能拿到ActivityInfo
                 * public static final ActivityInfo generateActivityInfo(Activity a,int flags,PackageUserState state,int userId)
                 *
                 */
                Method generateActivityInfoMethod = mPackageParserClass.getMethod("generateActivityInfo", mActivity.getClass()
                        , int.class, mPackageUserState, int.class);
                // 执行此方法，拿到ActivityInfo
                ActivityInfo mActivityInfo = (ActivityInfo) generateActivityInfoMethod.invoke(null,mActivity, 0, mPackageUserState.newInstance(), userId);
                String receiverClassName = mActivityInfo.name;
                Log.e(TAG, "广播名：" + receiverClassName);

                Class<?> mStaticReceiverClass = getClassLoader().loadClass(receiverClassName);

                BroadcastReceiver broadcastReceiver = (BroadcastReceiver) mStaticReceiverClass.newInstance();

                for (IntentFilter intentFilter : intents) {

                    // 注册广播
                    context.registerReceiver(broadcastReceiver, intentFilter);
                    broadcastReceivers.add(broadcastReceiver);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public void unregisterBroadcast(){

        for (BroadcastReceiver broadcastReceiver : broadcastReceivers) {
            context.unregisterReceiver(broadcastReceiver);
        }
    }


}
