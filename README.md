# MyLog


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
	        compile 'com.github.hss01248:Mylog:1.0.0'
	}
```

# addtion
app目录下: MyLogUtil封装
HttpLoggingM: okhttp日志打印拦截器优化版
