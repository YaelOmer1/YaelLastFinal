package com.omer.yaellastfinal.view;

import android.graphics.Bitmap;

public class Widget {

    private int x;
    private int y;

    private Bitmap bitmap;

//    public Widget(int x, int y, int width, int height, Bitmap bitmap ) {
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.bitmap = bitmap;
//    }

    public Widget(int x, int y, Bitmap bitmap ) {
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

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public boolean isCollideWithPoint(int x, int y)
    {
        return x>=this.x && x<=this.x+this.bitmap.getWidth() &&
                y>=this.y && y<=this.y+this.bitmap.getHeight();
    }

}
