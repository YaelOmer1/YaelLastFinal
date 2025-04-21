package com.omer.yaellastfinal.view;

import android.graphics.Bitmap;

public class BallWidget {

    private int x;
    private int y;

    private static int width;
    private static int height;


    private Bitmap bitmap;

    public BallWidget(int x, int y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        BallWidget.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        BallWidget.height = height;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public boolean isCollideWithPoint(int x, int y)
    {
        return x>=this.x && x<=this.x+width &&
               y>=this.y && y<=this.y+height;
    }
}
