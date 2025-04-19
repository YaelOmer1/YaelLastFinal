package com.omer.yaellastfinal.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;


public class BallPuzzleGame {

    public static final int MAX_JARS = 12;

    public static final int NUM_EMPTY_JARS = 2;

    // Max colors in any game
    public static final int MAX_BALLS_COLORS = MAX_JARS - NUM_EMPTY_JARS;

    private int level;

    private List<Jar> jarsList;
    private Difficulty difficulty;
    private int numberOfColors;
    private int numOfJars;


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
    }

    private void mixBalls(int swaps)
    {
        Random random = new Random();
        //int swaps = difficulty.getNumOfShuffles() * 10;

        for (int i = 0; i < swaps; i++) {
            Jar fromJar = jarsList.get(random.nextInt(numOfJars));
            while (fromJar.getBalls().isEmpty()) {
                fromJar = jarsList.get(random.nextInt(numOfJars));
            }

            Jar toJar = jarsList.get(random.nextInt(numOfJars));
            while (toJar == fromJar || toJar.getBalls().size() >= 4) {
                toJar = jarsList.get(random.nextInt(numOfJars));
            }

            Ball ball = fromJar.removeBall();
            toJar.addBall(ball);
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


}
