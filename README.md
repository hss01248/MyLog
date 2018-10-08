# MyLog

[![](https://jitpack.io/v/hss01248/MyLog.svg)](https://jitpack.io/#hss01248/MyLog)

# use


Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```

	dependencies {
	        compile 'com.github.hss01248:Mylog:1.0.6'
	}
```



# API

```
//初始化
 /**
     *
     * @param debug
     * @param gloablTag
     * @param methodOffset 直接适用MyLog.xx时,methodOffset传1.每封装一层,加1.
     * @param iJson  object转json字符串的功能,外部提供
     */
    public static void init(boolean debug,String gloablTag,int methodOffset,IJsonToStr iJson)

//使用:
MLog.xxx
如:
d(String tag, String message) 
d(String message)
....

```

# 特性

* 传递object,自动识别类型, 数组,list,array,均格式化打印,普通object拆解一层打印
* json格式化: 单行打印,超过3990自动剪切换行,避免logcat4096后信息遗失的问题
* 可以设tag,也可以不设tag

# addtion

* HttpLoggingM: okhttp日志打印拦截器优化版

* MLog.printStack(Throwable e): 内部判断是否为debug环境,是的话才调用e.printStacktrace().

* .bitmap(Bitmap bitmap)  : 打印bitmap四个顶点的像素点的RGB值

* TheCrashHandder: 崩溃时日志写入到本地并立刻打开查看的工具

  ```
  if(Config.isDebugEnvironment()){
              TheCrashHandler.getInstance().init(this,
                      Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/akucrash",
                      new TheCrashHandler.IOpenText() {
                          @Override
                          public Uri fileToUri(File file) {
                              return OpenUri.fromFile(MyApplication.this,file);
                          }
                      });
          }
  ```

  # 打印效果:

  json:

  > MLog.json()或者MLog.objAsJson()

  ![json](/art/json.jpg)

> 下方是 MLog.obj()的各个效果:

array:

![array](/art/array.jpg)



map:

![map](/art/map.jpg)



javabean:

![javabean](/art/javabean.jpg)



activity:

![activity](/art/activity.jpg)



# thanks

* [LogDelegate](https://github.com/tianzhijiexian/LogDelegate)
* [xLog](https://github.com/elvishew/xLog)