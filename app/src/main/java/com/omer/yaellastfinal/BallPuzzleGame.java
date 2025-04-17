package com.omer.yaellastfinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.omer.yaellastfinal.model.Ball;
import com.omer.yaellastfinal.model.ColorBall;
import com.omer.yaellastfinal.model.Difficulty;
import com.omer.yaellastfinal.model.Jar;

import java.util.ArrayList;

import java.util.Random;


public class BallPuzzleGame {
    private ArrayList<Jar> jarsArrayList;
    private Difficulty difficulty;
    private int numberOfColors;
    private int numOfJars;


    public BallPuzzleGame(Difficulty difficulty) {

        this.jarsArrayList = new ArrayList<>();

        this.difficulty = difficulty;

        this.numOfJars = difficulty.getNumOfJars();
        this.numberOfColors = difficulty.getNumOfColors();
        startGame();
    }
    
    public void startGame() {
        initializeJars();
        mixBalls();
    }

    private void initializeJars() {
        jarsArrayList.clear();

        ColorBall[] allColors = ColorBall.values();


        for (int i = 0; i < numberOfColors; i++) {
            Jar jar = new Jar();


            for (int j = 0; j < 4; j++) {
                jar.addBall(new Ball(allColors[i]));
            }

            jarsArrayList.add(jar);
        }

        for (int i = 0; i < 2; i++) {
            jarsArrayList.add(new Jar());
        }
    }

    private void mixBalls() {
        Random random = new Random();
        int swaps = difficulty.getNumOfShuffles() * 10;

        for (int i = 0; i < swaps; i++) {
            Jar fromJar = jarsArrayList.get(random.nextInt(numOfJars));
            while (fromJar.getBalls().isEmpty()) {
                fromJar = jarsArrayList.get(random.nextInt(numOfJars));
            }

            Jar toJar = jarsArrayList.get(random.nextInt(numOfJars));
            while (toJar == fromJar || toJar.getBalls().size() >= 4) {
                toJar = jarsArrayList.get(random.nextInt(numOfJars));
            }


            Ball ball = fromJar.removeBall();
            toJar.addBall(ball);
        }
    }


    public ArrayList<Jar> getJarsArrayList() {

        return jarsArrayList;
    }

    public void setJarsArrayList(ArrayList<Jar> jarsArrayList) {
        this.jarsArrayList = jarsArrayList;
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
