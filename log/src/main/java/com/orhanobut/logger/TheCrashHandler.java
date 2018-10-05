package com.orhanobut.logger;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.需要文件读写权限
 * 2.路径和子路径外部传入: 示例:
 *      Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/crashlog/
 * 3.是否使用此工具交由外部判断
 *
 * Created by huangshuisheng on 2018/8/20.
 */

public class TheCrashHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";
    private static TheCrashHandler INSTANCE = new TheCrashHandler();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Map<String, String> infos = new HashMap<String, String>();
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    //String path = "/sdcard/lesongcrash/";
    String path;
    IOpenText openText;

    private int mAppCount = 0;
    private  boolean isCrashing;

    private TheCrashHandler() {
    }

    public static TheCrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Application context,String logDir,IOpenText iOpenText) {
        mContext = context;
        path = logDir;
        openText = iOpenText;
        Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);

        /*context.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                mAppCount++;
                if(mAppCount == 1){
                    //回到前台
                    if(isCrashing){
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }

                }
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                mAppCount--;
                if (mAppCount == 0) {
                    //切到后台
                    Log.d("xx","background.....");
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });*/
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            //打开日志文件
            try {
                ex.printStackTrace();
                Thread.sleep(15000);
            } catch (Exception e) {
                e.printStackTrace();
                //Log.e(TAG, "error : ", e);
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    private boolean handleException(final Throwable ex) {
        if (ex == null) {
            return false;
        }
        isCrashing = true;
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Looper.loop();
                if(openText !=null){
                    openText.toast("crash : "+ex.getMessage());
                }
            }
        }.start();

        collectDeviceInfo(mContext);
        String str = saveCrashInfo2File(ex);
        if(!TextUtils.isEmpty(str) && openText !=null){
            openText.open(str);
        }
        return true;
    }

    public void collectDeviceInfo(Context ctx) {
        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(),
                    PackageManager.GET_ACTIVITIES);

            if (pi != null) {
                String versionName = pi.versionName == null ? "null"
                        : pi.versionName;
                String versionCode = pi.versionCode + "";
                infos.put("versionName", versionName);
                infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException e) {
            //Log.e(TAG, "an error occured when collect package info", e);
            e.printStackTrace();
        }

        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                infos.put(field.getName(), field.get(null).toString());
                Log.d(TAG, field.getName() + " : " + field.get(null));
            } catch (Exception e) {
                //Log.e(TAG, "an error occured when collect crash info", e);
                e.printStackTrace();
            }
        }
    }

    private String saveCrashInfo2File(Throwable ex) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : infos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + "=" + value + "\n");
        }

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();

        String result = writer.toString();
        sb.append(result);
        try {
            long timestamp = System.currentTimeMillis();
            String time = formatter.format(new Date());
            String fileName = "crash-" + time + "-" + timestamp + ".txt";

            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir,fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(sb.toString().getBytes());
            fos.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            //Log.e(TAG, "an error occured while writing file...", e);
            e.printStackTrace();

        }
        return null;
    }

    public interface IOpenText{

        /**
         * 注意7.0以上的文件uri兼容性
         * @param path
         */
        void open(String path);

        /**
         * 注意要抛到ui线程执行.似乎没用,crash时主线程阻塞了
         * @param text
         */
        void toast(String text);
    }

}
