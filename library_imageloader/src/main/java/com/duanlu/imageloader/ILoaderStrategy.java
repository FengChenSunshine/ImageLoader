package com.duanlu.imageloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by 枫尘 on 2019/3/8  16:01.
 *
 * @author DUANLU
 * @version 1.0.0
 * @class ILoaderStrategy
 * @describe 加载器方法定义.
 */
public interface ILoaderStrategy {

    void load(@NonNull LoaderOptions options);

    void clearCache(@NonNull Context context, View targetView);

    void clearMemoryCache(@NonNull Context context);

    void clearDiskCache(@NonNull Context context);
}
