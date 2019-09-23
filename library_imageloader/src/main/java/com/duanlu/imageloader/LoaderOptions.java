package com.duanlu.imageloader;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.view.View;

import java.io.File;

/**
 * Created by 枫尘 on 2019/3/8  16:02.
 *
 * @author DUANLU
 * @version 1.0.0
 * @class LoaderOptions
 * @describe 图片加载信息配置类.
 */
public class LoaderOptions {

    protected Context mContext;
    @DrawableRes
    public int mDrawableResId;
    public String mPath;
    public File file;
    public Uri mUri;
    @Shape
    public int mShape = Shape.DEFAULT;
    public int mCornerRadius;
    public int mLeftTopCornerRadius;
    public int mRightTopCornerRadius;
    public int mRightBottomCornerRadius;
    public int mLeftBottomCornerRadius;
    public int mTargetWidth;
    public int mTargetHeight;
    public View mTargetView;
    @DrawableRes
    private int mPlaceholder;
    @DrawableRes
    private int mError;

    public LoaderOptions(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public LoaderOptions load(@DrawableRes int drawableResId) {
        this.mDrawableResId = drawableResId;
        return this;
    }

    public LoaderOptions load(String path) {
        this.mPath = path;
        return this;
    }

    public LoaderOptions load(File file) {
        this.file = file;
        return this;
    }

    public LoaderOptions load(Uri uri) {
        this.mUri = uri;
        return this;
    }

    public void into(View view) {
        this.mTargetView = view;
        ImageLoader.getInstance().load(this);
    }

    public LoaderOptions placeholder(int i) {
        this.mPlaceholder = i;
        return this;
    }

    public LoaderOptions error(int error) {
        this.mError = error;
        return this;
    }

    public LoaderOptions asCircle() {
        this.mShape = Shape.CIRCLE;
        return this;
    }

    public LoaderOptions asCornerRadius(int cornerRadius) {
        this.mShape = Shape.CORNER;
        this.mCornerRadius = cornerRadius;
        return this;
    }

    public LoaderOptions asCornerRadius(int leftTop, int rightTop, int rightBottom, int leftBottom) {
        return asCornerRadius(Shape.CORNER_LTRB, leftTop, rightTop, rightBottom, leftBottom);
    }

    public LoaderOptions asLeftCornerRadius(int left) {
        return asCornerRadius(Shape.CORNER_LEFT, left, 0, 0, left);
    }

    public LoaderOptions asLeftCornerRadius(int leftTop, int leftBottom) {
        return asCornerRadius(Shape.CORNER_LEFT, leftTop, 0, 0, leftBottom);
    }

    public LoaderOptions asTopCornerRadius(int top) {
        return asCornerRadius(Shape.CORNER_TOP, top, top, 0, 0);
    }

    public LoaderOptions asTopCornerRadius(int leftTop, int rightTop) {
        return asCornerRadius(Shape.CORNER_TOP, leftTop, rightTop, 0, 0);
    }

    public LoaderOptions asRightCornerRadius(int right) {
        return asCornerRadius(Shape.CORNER_RIGHT, 0, right, right, 0);
    }

    public LoaderOptions asRightCornerRadius(int rightTop, int rightBottom) {
        return asCornerRadius(Shape.CORNER_RIGHT, 0, rightTop, rightBottom, 0);
    }

    public LoaderOptions asBottomCornerRadius(int bottom) {
        return asCornerRadius(Shape.CORNER_BOTTOM, 0, 0, bottom, bottom);
    }

    public LoaderOptions asBottomCornerRadius(int leftBottom, int rightBottom) {
        return asCornerRadius(Shape.CORNER_BOTTOM, 0, 0, rightBottom, leftBottom);
    }

    private LoaderOptions asCornerRadius(@Shape int shape, int leftTop, int rightTop, int rightBottom, int leftBottom) {
        this.mShape = shape;
        this.mLeftTopCornerRadius = leftTop;
        this.mRightTopCornerRadius = rightTop;
        this.mRightBottomCornerRadius = rightBottom;
        this.mLeftBottomCornerRadius = leftBottom;
        return this;
    }

    public LoaderOptions asSquare() {
        this.mShape = Shape.SQUARE;
        return this;
    }

    public LoaderOptions asRectangle() {
        this.mShape = Shape.RECTANGLE;
        return this;
    }

    public LoaderOptions size(int targetWidth, int targetHeight) {
        this.mTargetWidth = targetWidth;
        this.mTargetHeight = targetHeight;
        return this;
    }

    public int getPlaceholder() {
        return this.mPlaceholder > 0 ? this.mPlaceholder
                : PlaceholderProvider.getInstance().getPlaceholderByShape(this.mShape);
    }

    public int getError() {
        return this.mError > 0 ? this.mError
                : PlaceholderProvider.getInstance().getErrorByShape(this.mShape);
    }

}
