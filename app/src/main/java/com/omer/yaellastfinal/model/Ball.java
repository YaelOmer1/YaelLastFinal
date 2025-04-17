package com.omer.yaellastfinal.model;

public class Ball {
    private ColorBall color;

    public Ball(ColorBall color) {
        this.color = color;
    }

    public ColorBall getColor() {
        return color;
    }

    public void setColor(ColorBall color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color=" + color.name() +
                '}';
    }
}
