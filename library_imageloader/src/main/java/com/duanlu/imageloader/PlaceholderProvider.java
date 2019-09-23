package com.duanlu.imageloader;

import android.support.annotation.DrawableRes;

/**
 * Created by 枫尘 on 2019/3/8  16:03.
 *
 * @author DUANLU
 * @version 1.0.0
 * @class PlaceholderProvider
 * @describe 图片加载全局默认占位图提供者.
 */
public class PlaceholderProvider {

    private static PlaceholderProvider sInstance;

    @DrawableRes
    public int mDefaultPlaceholder;
    @DrawableRes
    private int mDefaultError;
    @DrawableRes
    private int mCirclePlaceholder;
    @DrawableRes
    private int mCircleError;
    @DrawableRes
    private int mSquarePlaceholder;
    @DrawableRes
    private int mSquareError;
    @DrawableRes
    private int mRectanglePlaceholder;
    @DrawableRes
    private int mRectangleError;
    @DrawableRes
    private int mCornerRadiusPlaceholder;
    @DrawableRes
    private int mCornerRadiusError;

    public static PlaceholderProvider getInstance() {
        if (sInstance == null) {
            synchronized (PlaceholderProvider.class) {
                if (sInstance == null) {
                    sInstance = new PlaceholderProvider();
                }
            }
        }
        return sInstance;
    }

    private PlaceholderProvider() {
    }

    public PlaceholderProvider setDefault(int placeholder, int error) {
        this.mDefaultPlaceholder = placeholder;
        this.mDefaultError = error;
        if (this.mCirclePlaceholder <= 0) {
            this.mCirclePlaceholder = this.mDefaultPlaceholder;
        }
        if (this.mCircleError <= 0) {
            this.mCircleError = this.mDefaultError;
        }
        if (this.mSquarePlaceholder <= 0) {
            this.mSquarePlaceholder = this.mDefaultPlaceholder;
        }
        if (this.mSquareError <= 0) {
            this.mSquareError = this.mDefaultError;
        }
        if (this.mRectanglePlaceholder <= 0) {
            this.mRectanglePlaceholder = this.mDefaultPlaceholder;
        }
        if (this.mRectangleError <= 0) {
            this.mRectangleError = this.mDefaultError;
        }
        if (this.mCornerRadiusPlaceholder <= 0) {
            this.mCornerRadiusPlaceholder = this.mDefaultPlaceholder;
        }
        if (this.mCornerRadiusError <= 0) {
            this.mCornerRadiusError = this.mDefaultError;
        }
        return this;
    }

    public PlaceholderProvider setCircleDefault(int placeholder, int error) {
        this.mCirclePlaceholder = placeholder;
        this.mCircleError = error;
        return this;
    }

    public PlaceholderProvider setSquareDefault(int placeholder, int error) {
        this.mSquarePlaceholder = placeholder;
        this.mSquareError = error;
        return this;
    }

    public PlaceholderProvider setRectangleDefault(int placeholder, int error) {
        this.mRectanglePlaceholder = placeholder;
        this.mRectangleError = error;
        return this;
    }

    public PlaceholderProvider setCornerDefault(int placeholder, int error) {
        this.mCornerRadiusPlaceholder = placeholder;
        this.mCornerRadiusError = error;
        return this;
    }

    @DrawableRes
    protected int getPlaceholderByShape(@Shape int shape) {
        switch (shape) {
            case Shape.CIRCLE:
                return this.mCirclePlaceholder;
            case Shape.SQUARE:
                return this.mSquarePlaceholder;
            case Shape.RECTANGLE:
                return this.mRectanglePlaceholder;
            case Shape.CORNER:
                return this.mCornerRadiusPlaceholder;
            case Shape.DEFAULT:
            default:
                return this.mDefaultPlaceholder;
        }
    }

    @DrawableRes
    protected int getErrorByShape(@Shape int shape) {
        switch (shape) {
            case Shape.CIRCLE:
                return this.mCircleError;
            case Shape.SQUARE:
                return this.mSquareError;
            case Shape.RECTANGLE:
                return this.mRectangleError;
            case Shape.CORNER:
                return this.mCornerRadiusError;
            case Shape.DEFAULT:
            default:
                return this.mDefaultError;
        }
    }

}
