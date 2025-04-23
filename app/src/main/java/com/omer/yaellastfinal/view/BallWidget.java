package com.omer.yaellastfinal.view;

import android.graphics.Bitmap;

import com.omer.yaellastfinal.model.Ball;

public class BallWidget extends Widget{

    private Ball ball;

    public BallWidget(Ball ball, int x, int y, Bitmap bitmap) {
        super(x,y, bitmap);
        this.ball = ball;
    }

    public Ball getBall() {
        return ball;
    }

}
