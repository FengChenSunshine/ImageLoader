package com.duanlu.imageloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by 枫尘 on 2019/3/8  16:01.
 *
 * @author DUANLU
 * @version 1.0.0
 * @class ImageLoader
 * @describe 图片加载工具类.
 */
public class ImageLoader {

    private static ImageLoader sInstance;

    private ILoaderStrategy mLoaderStrategy;

    public static LoaderOptions with(Context context) {
        return new LoaderOptions(context);
    }

    private ImageLoader() {
    }

    protected static ImageLoader getInstance() {
        if (sInstance == null) {
            synchronized (ImageLoader.class) {
                if (sInstance == null) {
                    sInstance = new ImageLoader();
                }
            }
        }
        return sInstance;
    }

    public static void init(ILoaderStrategy loaderStrategy) {
        getInstance().mLoaderStrategy = loaderStrategy;
    }

    public void load(@NonNull LoaderOptions options) {
        check();
        this.mLoaderStrategy.load(options);
    }

    public static void clearCache(@NonNull Context context, View targetView) {
        getInstance().check();
        getInstance().mLoaderStrategy.clearCache(context, targetView);
    }

    public static void clearMemoryCache(@NonNull Context context) {
        getInstance().check();
        getInstance().mLoaderStrategy.clearMemoryCache(context);
    }

    public static void clearDiskCache(@NonNull Context context) {
        getInstance().check();
        getInstance().mLoaderStrategy.clearDiskCache(context);
    }

    private void check() {
        if (this.mLoaderStrategy == null) {
            throw new NullPointerException("Please set ILoaderStrategy!!!");
        }
    }

}