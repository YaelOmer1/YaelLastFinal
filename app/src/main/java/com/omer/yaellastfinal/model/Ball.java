package com.omer.yaellastfinal.model;

public class Ball {
    private Color color;

    public Ball(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color=" + color.name() +
                '}';
    }
}
