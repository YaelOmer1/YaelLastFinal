package com.omer.yaellastfinal.view;

import android.graphics.Bitmap;

import com.omer.yaellastfinal.model.Ball;
import com.omer.yaellastfinal.model.Jar;

public class JarWidget extends Widget{

    private Jar jar;

    public JarWidget(Jar jar, int x, int y, Bitmap bitmap) {
        super(x,y, bitmap);
        this.jar = jar;
    }

    public Jar getJar() {
        return jar;
    }

}
