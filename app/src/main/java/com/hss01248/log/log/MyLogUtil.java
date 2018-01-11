package com.hss01248.log.log;


import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.LogBuilder;
import com.orhanobut.logger.LogPrintStyle;
import com.orhanobut.logger.Logger;

/**
 * by huangshuisheng
 */
public class MyLogUtil {

    public final static boolean DEBUG = true;

    public static void init(){
        Logger.initialize(
            new LogBuilder()
                .logPrintStyle(new LogPrintStyle())
                .showMethodLink(true)
                .showThreadInfo(true)
                .tagPrefix("")
                .globalTag("haha")
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

    public static void format(String format, Object... args){
        if(DEBUG)
            Logger.d(format,args);
    }


}
