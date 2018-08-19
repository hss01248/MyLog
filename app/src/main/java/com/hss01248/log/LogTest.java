package com.hss01248.log;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.blankj.ALog;
import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.orhanobut.logger.IJsonToStr;
import com.orhanobut.logger.MyLog;
import com.socks.library.KLog;
import org.mym.plog.DebugPrinter;
import org.mym.plog.PLog;
import org.mym.plog.config.PLogConfig;

/**
 * by huangshuisheng
 */
public class LogTest {

    public final static boolean DEBUG = true;

    public static void init(Context context){
        intXlog();
        initKLog();
        initALog(context);
        initLogger();
        initPlog();


    }

    private static void initPlog() {
        PLog.init(new PLogConfig.Builder()
//                .emptyMsgLevel(Log.INFO)
            .forceConcatGlobalTag(true)
            .useAutoTag(true)
            .needThreadInfo(true)
            .needLineNumber(true)
            .globalTag("plog")
            .globalStackOffset(1)
            .build());

        PLog.prepare(new DebugPrinter(true));
    }

    /**
     * https://github.com/tianzhijiexian/LogDelegate
     */
    private static void initLogger() {
        /*Logger.initialize(
            new LogBuilder()
                .logPrintStyle(new LogPrintStyle())
                .showMethodLink(true)
                .showThreadInfo(true)
                .tagPrefix("LogDelegate")
                .globalTag("logger")
                .methodOffset(1)
                .logPriority(BuildConfig.DEBUG ? Log.VERBOSE : Log.ASSERT)
                .build());*/
        MyLog.init(true, "LogDelegate", new IJsonToStr() {
            @Override
            public String toStr(Object obj) {
                return JSON.toJSONString(obj);
            }
        });
    }

    private static void initALog(Context context) {
        ALog.Config config = ALog.init(context)
            .setLogSwitch(BuildConfig.DEBUG)// 设置log总开关，包括输出到控制台和文件，默认开
            .setConsoleSwitch(BuildConfig.DEBUG)// 设置是否输出到控制台开关，默认开
            .setGlobalTag("alog")// 设置log全局标签，默认为空
            // 当全局标签不为空时，我们输出的log全部为该tag，
            // 为空时，如果传入的tag为空那就显示类名，否则显示tag
            .setLogHeadSwitch(true)// 设置log头信息开关，默认为开
            .setLog2FileSwitch(false)// 打印log时是否存到文件的开关，默认关
            .setDir("")// 当自定义路径为空时，写入应用的/cache/log/目录中
            .setFilePrefix("")// 当文件前缀为空时，默认为"alog"，即写入文件为"alog-MM-dd.txt"
            .setBorderSwitch(true)// 输出日志是否带边框开关，默认开
            .setConsoleFilter(ALog.V)// log的控制台过滤器，和logcat过滤器同理，默认Verbose
            .setFileFilter(ALog.V)// log文件过滤器，和logcat过滤器同理，默认Verbose
            .setStackDeep(2);// log栈深度，默认为1
        ALog.d(config.toString());
    }


    /**
     * https://github.com/ZhaoKaiQiang/KLog
     */
    private static void initKLog() {
        KLog.init(BuildConfig.DEBUG, "klog");
    }


    /**
     * https://github.com/elvishew/xLog
     */
    private static void intXlog() {
        LogConfiguration config = new LogConfiguration.Builder()
            .logLevel(DEBUG ? LogLevel.ALL             // Specify log level, logs below this level won't be printed, default: LogLevel.ALL
                : LogLevel.NONE)
            .tag("xlog")                                         // Specify TAG, default: "X-LOG"
            .t()                                                   // Enable thread info, disabled by default
            .st(2)                                                 // Enable stack trace info with depth 2, disabled by default
            .b()
            .build();
        XLog.init(config);
        /*private static final String X_LOG_PATH = Environment
			.getExternalStorageDirectory().getPath() + "/installment/xlog/";

        Printer androidPrinter = new AndroidPrinter();             // 通过 android.util.Log 打印日志的打印器
		Printer systemPrinter = new SystemPrinter();               // 通过 System.out.println 打印日志的打印器
		Printer filePrinter = new FilePrinter                      // 打印日志到文件的打印器
				.Builder(X_LOG_PATH)                              // 指定保存日志文件的路径
				.fileNameGenerator(
						new DateFileNameGenerator())        // 指定日志文件名生成器，默认为 ChangelessFileNameGenerator("log")
				.request();
			*/
    }

    public static void d(String tag, String message) {
        if (DEBUG){
            ALog.dTag(tag,message);
            KLog.d(tag,message);
            XLog.tag(tag).d(message);
        }

    }

    public static void i(String tag, String message) {
        if (DEBUG)
            XLog.tag(tag).i(message);
    }

    public static void w(String tag, String message) {
        if (DEBUG)
            XLog.tag(tag).w(message);
    }

    public static void e(String tag, String message) {
        if (DEBUG)
            XLog.tag(tag).e(message);
    }

    public static void v(String tag, String message) {
        if (DEBUG)
            XLog.tag(tag).v(message);
    }

    public static void d(String message) {
        if (DEBUG)
            XLog.e( message);
    }

    public static void i(String message) {
        if (DEBUG)
            XLog.i( message);
    }

    public static void w(String message) {
        if (DEBUG)
            XLog.w( message);
    }

    public static void e(String message) {
        if (DEBUG)
            XLog.e( message);
    }

    public static void v(String message) {
        if (DEBUG)
            XLog.v( message);
    }

    public static void json(String obj){
        if(DEBUG){
            ALog.json(obj);
           KLog.json(obj);
            MyLog.json(obj);
            XLog.json(TextUtils.isEmpty(obj)?"":obj);
            PLog.objects(obj);
        }
    }
    public static void xml(String xml){
        if(DEBUG)
            XLog.xml(TextUtils.isEmpty(xml)?"":xml);
    }

    public static void obj(Object obj){
        if(DEBUG){
            ALog.e(obj);
            KLog.e(obj);
            MyLog.objAsJson(obj);
            XLog.d(obj==null? "null" :obj);
            PLog.objects(obj);


        }

    }
    public static void arr(Object[] arr){
        if(DEBUG)
            XLog.d(arr==null ? "null":arr);
    }

    public static void format(String format, Object... objects){
        if(DEBUG)
            XLog.e(format,objects);
    }


}
