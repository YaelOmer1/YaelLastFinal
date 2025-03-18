package com.omer.yaellastfinal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Jar {

    private Stack<Ball> balls;

    public Jar() {
        balls = new Stack<>();
    }

    public void addBall(Ball ball) {
        if (balls.size() < 4) {
            balls.add(ball);
        } else {
            System.out.println("Cannot add more balls to this tube");
        }
    }
    public Ball removeBall() {

        if (balls.isEmpty())
            return null;
        else
            return balls.pop(); // מבצע הסרה לפי סדר LIFO
    }

    public Stack<Ball> getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        return balls.toString();
    }

}

