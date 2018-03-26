package com.orhanobut.logger;


import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

/**
 * by huangshuisheng
 */
public class XLogUtil {

    private  static boolean DEBUG = false;
    private static Jsonfy jsonfy;

    public static void init(boolean isPrintLog,String globalTag,Jsonfy jsonfy){
        DEBUG = isPrintLog;
        XLogUtil.jsonfy = jsonfy;
        Logger.initialize(
            new LogBuilder()
                .logPrintStyle(new LogPrintStyle())
                .showMethodLink(true)
                .showThreadInfo(true)
                .tagPrefix("")
                .globalTag(globalTag)
                .methodOffset(1)
                .logPriority(DEBUG ? Log.VERBOSE : Log.ASSERT)
                .build());


        /*LogConfiguration config = new LogConfiguration.Builder()
            .logLevel(DEBUG ? LogLevel.ALL             // Specify log level, logs below this level won't be printed, default: LogLevel.ALL
                : LogLevel.NONE)
            .tag("akulaku")                                         // Specify TAG, default: "X-LOG"
            .t()                                                   // Enable thread info, disabled by default
            .st(2)                                                 // Enable stack trace info with depth 2, disabled by default
            .b()
            .build();
        XLog.init(config);*/
    }



    public static void d(String tag, String message) {
        if (DEBUG)
            Logger.t(tag).d(message);
    }

    public static void i(String tag, String message) {
        if (DEBUG)
            Logger.t(tag).i(message);
    }

    public static void w(String tag, String message) {
        if (DEBUG)
            Logger.t(tag).w(message);
    }

    public static void e(String tag, String message) {
        if (DEBUG)
            Logger.t(tag).e(message);
    }

    public static void json(String tag, String msg){
        if(DEBUG){
            Logger.json(TextUtils.isEmpty(msg)?"":msg,tag);
        }
    }

    public static void exception(String tag, String message, Throwable e) {
        if (DEBUG)
            Logger.t(tag).e(e,message);
    }

    public static void v(String tag, String message) {
        if (DEBUG)
            Logger.t(tag).v(message);
    }

    public static void d(String message) {
        if (DEBUG)
            Logger.d( message);
    }

    public static void i(String message) {
        if (DEBUG)
            Logger.i( message);
    }

    public static void w(String message) {
        if (DEBUG)
            Logger.w( message);
    }

    public static void e(String message) {
        if (DEBUG)
            Logger.e( message);
    }

    public static void exception(String message, Throwable e) {
        if (DEBUG)
            Logger.e(e,message);
    }

    public static void v(String message) {
        if (DEBUG)
            Logger.v( message);
    }

    public static void json(String msg){
        if(DEBUG){
            Logger.json(TextUtils.isEmpty(msg)?"":msg);
        }
    }

    public static void json(Object obj){
        if(DEBUG){
            if(obj ==null){
                Logger.i("null");
            }else if(obj instanceof String){
                Logger.json((String)obj);
            }else {
                Logger.json(jsonfy.toJson(obj));
            }

        }
    }


    public static void xml(String xml){
        if(DEBUG)
            Logger.xml(TextUtils.isEmpty(xml)?"":xml);
    }

    public static void obj(Object obj){
        if(DEBUG)
            Logger.object(obj);
    }

    public static void obj(String tag, Object obj){
        if(DEBUG)
            Logger.object(tag,obj);
    }

    /**
     * 把对象转换为json然后格式化打印
     * @param obj
     */
    public static void objAsJson(Object obj){
        if(DEBUG){
            String json = jsonfy.toJson(obj);
            Logger.json(json);
        }

    }
    public static void objAsJson(Object obj,String tag){
        if(DEBUG){
            String json = jsonfy.toJson(obj);
            Logger.json(json,tag);
        }

    }

    public static void bitmap(Bitmap bitmap){
        if(DEBUG){
            int width = bitmap.getWidth()-1;
            int height = bitmap.getHeight();

            MyColor[][] frams = new MyColor[6][2];
            frams[0][0] = new MyColor(bitmap.getPixel(0,0));
            frams[0][1] = new MyColor(bitmap.getPixel(width,0));
            frams[1][0] = new MyColor(bitmap.getPixel(0,1));
            frams[1][1] = new MyColor(bitmap.getPixel(width,1));
            frams[2][0] = new MyColor(bitmap.getPixel(0,2));
            frams[2][1] = new MyColor(bitmap.getPixel(width,2));


            frams[3][0] = new MyColor(bitmap.getPixel(0,height-3));
            frams[3][1] = new MyColor(bitmap.getPixel(width,height-3));
            frams[4][0] = new MyColor(bitmap.getPixel(0,height-2));
            frams[4][1] = new MyColor(bitmap.getPixel(width,height-2));
            frams[5][0] = new MyColor(bitmap.getPixel(0,height-1));
            frams[5][1] = new MyColor(bitmap.getPixel(width,height-1));

            String[][] arr = new String[6][2];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = (i+1)+"-"+(j+1);
                }
            }
            Logger.object(frams);
        }
    }

    public static void format(String format, Object... args){
        if(DEBUG)
            Logger.d(format,args);
    }


}
