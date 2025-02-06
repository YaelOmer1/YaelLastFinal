package com.omer.yaellastfinal;

import java.util.LinkedList;
import java.util.Queue;


public class Jar {

    private Queue<Ball> balls;

    public Jar() {
        balls = new LinkedList<>();
    }

    public void addBall(Ball ball) {
        if (balls.size() < 4) {
            balls.add(ball);
        } else {
            System.out.println("Cannot add more balls to this tube");
        }
    }
    public Ball removeBall() {
        return balls.poll(); // מבצע הסרה לפי סדר FIFO
    }

    public Queue<Ball> getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        return balls.toString();
    }

}

