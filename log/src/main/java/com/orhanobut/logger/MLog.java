package com.orhanobut.logger;


import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;



/**
 * by huangshuisheng
 */
public class MLog {

    private   static boolean DEBUG ;
    private static IJsonToStr json;

    /**
     *
     * @param debug
     * @param gloablTag
     * @param methodOffset 直接适用MyLog.xx时,methodOffset传1.每封装一层,加1.
     * @param iJson  object转json字符串的功能,外部提供
     */
    public static void init(boolean debug,String gloablTag,int methodOffset,IJsonToStr iJson) {
        DEBUG = debug;
        json = iJson;

        Logger.initialize(
                new LogBuilder()
                        .logPrintStyle(new LogPrintStyle())
                        .showMethodLink(true)
                        .showThreadInfo(true)
                        .tagPrefix("")
                        .globalTag(gloablTag)
                        .methodOffset(methodOffset)
                        .logPriority(DEBUG ? Log.VERBOSE : Log.ASSERT)
                        .build());



       /* AndroidAppender.Builder androidBuild = new AndroidAppender.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public boolean intercept(LogData logData) {
                        return false;
                    }
                });*/

        /*File log = FileUtils.getLogDir(context);
        String log_path = log.getAbsolutePath() + File.separator + "log.txt";
        FileAppender.Builder fileBuild = new FileAppender.Builder(context)
                .setLogFilePath(log_path);

        me.pqpo.librarylog4a.logger.Logger logger = new AppenderLogger.Builder()
                .addAppender(androidBuild.create())
                .addAppender(fileBuild.create())
                .create();

        Log4a.setLogger(logger);*/



    }


    public static void d(String tag, String message) {
        if (DEBUG) {
            Logger.t(tag).d(message);
        }
    }

    public static void i(String tag, String message) {
        if (DEBUG) {
            Logger.t(tag).i(message);
        }
    }

    public static void w(String tag, String message) {
        if (DEBUG) {
            Logger.t(tag).w(message);
        }
    }

    public static void e(String tag, String message) {
        if (DEBUG) {
            Logger.t(tag).e(message);
        }
    }

    public static void json(String tag, String msg) {
        if (DEBUG) {
            Logger.json(TextUtils.isEmpty(msg) ? "" : msg, tag);
        }
    }

    public static void exception(String tag, String message, Throwable e) {
        if (DEBUG) {
            Logger.t(tag).e(e, message);
        }
    }

    public static void v(String tag, String message) {
        if (DEBUG) {
            Logger.t(tag).v(message);
        }
    }

    public static void d(String message) {
        if (DEBUG) {
            Logger.d(message);
        }
    }

    public static void i(String message) {
        if (DEBUG) {
            Logger.i(message);
        }
    }

    public static void w(String message) {
        if (DEBUG) {
            Logger.w(message);
        }
    }

    public static void e(String message) {
        if (DEBUG) {
            Logger.e(message);
        }
    }

    public static void printStack(Throwable e) {
        if (DEBUG) {
            if(e !=null){
                e.printStackTrace();
            }
        }
    }
    public static void printStack(String msg) {
        if (DEBUG) {
            if(!TextUtils.isEmpty(msg)){
                new Throwable(msg).printStackTrace();
            }
        }
    }

    public static void exception(String message, Throwable e) {
        if (DEBUG) {
            Logger.e(e, message);
        }
    }

    public static void v(String message) {
        if (DEBUG) {
            Logger.v(message);
        }
    }

    public static void json(String msg) {
        if (DEBUG) {
            Logger.json(TextUtils.isEmpty(msg) ? "" : msg);
        }
    }

    public static void json(Object obj) {
        if (DEBUG) {
            if (obj == null) {
                Logger.i("null");
            } else if (obj instanceof String) {
                Logger.json((String) obj);
            } else if(obj instanceof String){
                Logger.json((String)obj);
            }else {
                Logger.json(json.toStr(obj));
            }

        }
    }

    public static void xml(String xml) {
        if (DEBUG) {
            Logger.xml(TextUtils.isEmpty(xml) ? "" : xml);
        }
    }

    public static void obj(Object obj) {
        if (DEBUG) {
            Logger.object(obj);
        }
    }

    /**
     * 把对象转换为json然后格式化打印
     * @param obj
     */
    public static void objAsJson(Object obj){
        if(DEBUG){
            String json2 = json.toStr(obj);
            Logger.json(json2);
        }

    }
    public static void objAsJson(Object obj,String tag){
        if(DEBUG){
            String json2 = json.toStr(obj);
            Logger.json(json2,tag);
        }

    }

    public static void obj(String tag, Object obj) {
        if (DEBUG) {
            Logger.object(tag, obj);
        }
    }

    public static void format(String format, Object... args) {
        if (DEBUG) {
            Logger.i(format, args);
        }
    }

    public static void bitmap(Bitmap bitmap) {
        if (DEBUG) {
            if (bitmap == null) {
                MLog.d("bitmap is null");
                return;
            }
            int width = bitmap.getWidth() - 1;
            int height = bitmap.getHeight();

            MyColor[][] frams = new MyColor[6][2];
            frams[0][0] = new MyColor(bitmap.getPixel(0, 0));
            frams[0][1] = new MyColor(bitmap.getPixel(width, 0));
            frams[1][0] = new MyColor(bitmap.getPixel(0, 1));
            frams[1][1] = new MyColor(bitmap.getPixel(width, 1));
            frams[2][0] = new MyColor(bitmap.getPixel(0, 2));
            frams[2][1] = new MyColor(bitmap.getPixel(width, 2));

            frams[3][0] = new MyColor(bitmap.getPixel(0, height - 3));
            frams[3][1] = new MyColor(bitmap.getPixel(width, height - 3));
            frams[4][0] = new MyColor(bitmap.getPixel(0, height - 2));
            frams[4][1] = new MyColor(bitmap.getPixel(width, height - 2));
            frams[5][0] = new MyColor(bitmap.getPixel(0, height - 1));
            frams[5][1] = new MyColor(bitmap.getPixel(width, height - 1));

            String[][] arr = new String[6][2];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = (i + 1) + "-" + (j + 1);
                }
            }
            Logger.object(frams);
        }
    }


}
