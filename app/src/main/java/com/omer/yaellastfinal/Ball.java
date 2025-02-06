package com.omer.yaellastfinal;

public class Ball {
    private Color color;
    public Ball(Color color){
        this.color=color;
    }
    public Color getColor(){
        return color;
    }
    @Override
    public String toString() {
        return color.toString();
    }

}
