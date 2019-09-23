package com.duanlu.imageloader;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({Shape.DEFAULT, Shape.CIRCLE, Shape.SQUARE, Shape.RECTANGLE
        , Shape.CORNER, Shape.CORNER_LTRB, Shape.CORNER_LEFT, Shape.CORNER_TOP, Shape.CORNER_RIGHT, Shape.CORNER_BOTTOM})
public @interface Shape {
    int DEFAULT = 0;//默认.
    int CIRCLE = 1;//圆形.
    int SQUARE = 2;//正方形.
    int RECTANGLE = 3;//矩形.
    int CORNER = 4;//圆角.
    int CORNER_LTRB = 5;//圆角-上下左右.
    int CORNER_LEFT = 6;//圆角-左.
    int CORNER_TOP = 7;//圆角-上.
    int CORNER_RIGHT = 8;//圆角-右.
    int CORNER_BOTTOM = 9;//圆角-下.
}
