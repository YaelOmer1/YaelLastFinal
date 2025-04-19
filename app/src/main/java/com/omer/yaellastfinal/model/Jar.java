package com.omer.yaellastfinal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Jar {

    public static final int MAX_BALLS_IN_JAR = 4;

    private Stack<Ball> balls;


    public Jar() {

        balls = new Stack<>();
    }

    public void addBall(Ball ball) {
        if (balls.size() < 4) {
            balls.add(ball);
        }
    }
    public Ball removeBall() {

        if (balls.isEmpty())
            return null;
        else
            return balls.pop();
    }

    public Stack<Ball> getBalls() {

        return balls;
    }

    public List<Ball> getBallsAsList()
    {
        return new ArrayList<>(balls);
    }

    @Override
    public String toString() {

        return balls.toString();
    }

}

