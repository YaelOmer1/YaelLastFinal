package com.omer.yaellastfinal.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Stack;


public class BallPuzzleGame {

    public static final int MAX_JARS = 12;

    public static final int NUM_EMPTY_JARS = 2;

    // Max colors in any game
    public static final int MAX_BALLS_COLORS = MAX_JARS - NUM_EMPTY_JARS;

    private int level;

    private List<Jar> jarsList;

    private List<Jar> jarsListOfStartGame;

    private Difficulty difficulty;
    private int numberOfColors;
    private int numOfJars;

    private Stack<Command> stackCommands = new Stack<>();
    private Stack<Command> stackCommandsReversed = new Stack<>();

    public BallPuzzleGame(Difficulty difficulty) {

        // this.jarsList = new LinkedList<>();
        this.jarsList = new ArrayList<>();

//        this.difficulty = difficulty;
//
//        this.numOfJars = difficulty.getNumOfJars();
//        this.numberOfColors = difficulty.getNumOfColors();
    }
    
    public void startGame(int level) {
        this.level = level;
        //this.numOfJars = difficulty.getNumOfJars();
        this.numOfJars = 4 + (level-1)*2;
        //this.numberOfColors = difficulty.getNumOfColors();
        this.numberOfColors = numOfJars - NUM_EMPTY_JARS;

        initializeJars();
        mixBalls(50);
    }

    private void initializeJars() {
        jarsList.clear();

        ColorBall[] allColors = ColorBall.values();

        int numOfFullJars = numberOfColors;
        for (int i = 0; i < numOfFullJars; i++) {
            Jar jar = new Jar();

            ColorBall color = allColors[i];

            for (int countBalls = 0; countBalls < 4; countBalls++) {
                jar.addBall(new Ball(color));
            }

            jarsList.add(jar);
        }

        // Adding the 2 empty jars
        for (int i = 0; i < 2; i++) {
            jarsList.add(new Jar());
        }

//        for(Jar jar : jarsList)
//        {
//            Jar jar2 = new Jar();
//            jar2.setBallsStack((Stack<Ball>)jar.getBallsStack().clone());
//            jarsListOfStartGame.add(jar2);
//        }
    }

    private void mixBalls(int swaps)
    {
        Random random = new Random();
        //int swaps = difficulty.getNumOfShuffles() * 10;

        for (int i = 0; i < swaps; i++) {
            Jar fromJar = jarsList.get(random.nextInt(numOfJars));
            while (fromJar.getBallsStack().isEmpty()) {
                fromJar = jarsList.get(random.nextInt(numOfJars));
            }

            Jar toJar = jarsList.get(random.nextInt(numOfJars));
            while (toJar == fromJar || toJar.getBallsStack().size() >= 4) {
                toJar = jarsList.get(random.nextInt(numOfJars));
            }

            Ball ball = fromJar.removeBall();
            toJar.addBall(ball);
        }
    }

    public Stack<Command> getStackCommands() {
        return stackCommands;
    }
    public Stack<Command> getStackCommandsReversed() {
        return stackCommandsReversed;
    }


    public void setStackCommands(Stack<Command> stackCommands) {
        this.stackCommands = stackCommands;
    }

    public void goBackOneMove()
    {
        if (!stackCommands.isEmpty())
        {
            Command command = stackCommands.pop();
            Ball ball = command.getTargetJar().removeBall();
            command.getSourceJar().addBall(ball);
            stackCommandsReversed.push(command);
        }
    }

    public void goForwardOneMove()
    {
        if (!stackCommandsReversed.isEmpty())
        {
            Command command = stackCommandsReversed.pop();
            Ball ball = command.getSourceJar().removeBall();
            command.getTargetJar().addBall(ball);
            stackCommands.push(command);
        }
    }

    public List<Jar> getJarsList() {

        return jarsList;
    }

    public void setJarsList(List<Jar> jarsList) {
        this.jarsList = jarsList;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public void setNumberOfColors(int numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    public int getNumOfJars() {
        return numOfJars;
    }

    public void setNumOfJars(int numOfJars) {
        this.numOfJars = numOfJars;
    }

    public boolean isWin()
    {
        for (Jar jar : jarsList)
        {
            if (jar.getBallsStack().isEmpty())
            {
                continue;
            }

            if (jar.getBallsStack().size() < Jar.MAX_BALLS_IN_JAR)
            {
                return false;
            }

            List<Ball> listBallsInJar = jar.getBallsAsList();
            Ball firstBall = listBallsInJar.get(0);
            for (int i=1; i<listBallsInJar.size(); i++)
            {
                if (firstBall.getColor() != listBallsInJar.get(i).getColor())
                {
                    return false;
                }
            }

        }

        return true;
    }

    public void goBackToStart()
    {
        for (int i=0; i<jarsListOfStartGame.size(); i++) {
            Stack<Ball> ballsStack = jarsListOfStartGame.get(i).getBallsStack();
            jarsList.get(i).setBallsStack(ballsStack);
        }
    }
}
