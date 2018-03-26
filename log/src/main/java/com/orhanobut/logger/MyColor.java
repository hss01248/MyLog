package com.orhanobut.logger;

/**
 * Created by huangshuisheng on 2018/1/17.
 */

public class MyColor {
    int val;

    public MyColor(int val) {
        this.val = val;
    }

    public static int alpha(int color) {
        return color >>> 24;
    }

    /**
     * Return the red component of a color int. This is the same as saying
     * (color >> 16) & 0xFF
     */
    public static int red(int color) {
        return (color >> 16) & 0xFF;
    }

    /**
     * Return the green component of a color int. This is the same as saying
     * (color >> 8) & 0xFF
     */
    public static int green(int color) {
        return (color >> 8) & 0xFF;
    }

    /**
     * Return the blue component of a color int. This is the same as saying
     * color & 0xFF
     */
    public static int blue(int color) {
        return color & 0xFF;
    }

    @Override
    public String toString() {
        return String.format("[%d  %d  %d]",red(val),green(val),blue(val));
    }
}
