package com.omer.yaellastfinal.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Jar {

    public static final int MAX_BALLS_IN_JAR = 4;

    private Stack<Ball> ballsStack;


    public Jar() {

        ballsStack = new Stack<>();
    }

    public void addBall(Ball ball) {
        if (ballsStack.size() < 4) {
            ballsStack.add(ball);
        }
    }
    public Ball removeBall() {

        if (ballsStack.isEmpty())
            return null;
        else
            return ballsStack.pop();
    }

    public Stack<Ball> getBallsStack() {

        return ballsStack;
    }

    public void setBallsStack(Stack<Ball> ballsStack) {
        this.ballsStack = ballsStack;
    }

    public List<Ball> getBallsAsList()
    {
        List<Ball> listBalls = new ArrayList<>(ballsStack);
        Collections.reverse(listBalls);
        return listBalls;
    }

    @Override
    public String toString() {

        return ballsStack.toString();
    }

}

