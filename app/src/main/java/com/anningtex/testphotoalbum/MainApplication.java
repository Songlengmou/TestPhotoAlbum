package com.anningtex.testphotoalbum;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.anningtex.testphotoalbum.act.MainActivity;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tencent.mmkv.MMKV;

/**
 * @Author Song
 * @Date：2021-09-16
 */
public class MainApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //配置MMKV
        MMKV.initialize(context);
        //配置mageLoader
        configImageLoader();
        // Android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }
    }

    public static Context getContext() {
        return context;
    }

    public void configImageLoader() {
        // ImageLoader进行框架初使化操作-全局配置
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                //缓存图片最大的长和宽
                .memoryCacheExtraOptions(480, 800)
                //线程池的数量
                .threadPoolSize(2)
                .threadPriority(4)
                //设置内存缓存区大小
                .memoryCacheSize(5 * 1024 * 1024)
                //设置sd卡缓存区大小
                .diskCacheSize(20 * 1024 * 1024)
                // .diskCache(new UnlimitedDiscCache(cachefile))//自定义磁盘缓存目录
                //打印日志内容
                .writeDebugLogs()
                //给缓存的文件名进行md5加密处理
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .build();
        ImageLoader.getInstance().init(configuration);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}