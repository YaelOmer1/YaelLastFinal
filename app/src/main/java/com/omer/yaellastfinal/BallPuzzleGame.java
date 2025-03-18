package com.omer.yaellastfinal;

import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        this.numberOfColors = difficulty.getNumberOfColors();
        startGame();
    }
    
    public void startGame() {
        initializeJars();
        mixBalls();
    }
    private void initializeJars() {
        jarsArrayList.clear(); // Clear any existing jars

        Color[] allColors = Color.values();

        // Make sure we use only the required number of colors
        for (int i = 0; i < numberOfColors; i++) {
            Jar jar = new Jar();

            // Add 4 balls of the same color to the jar
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
        Random random = new Random(); // Define random once
        int swaps = difficulty.getNumOfShuffles() * 10; // Number of swaps

        for (int i = 0; i < swaps; i++) {
            // Step 1: Find a non-empty jar to pop from
            Jar fromJar = jarsArrayList.get(random.nextInt(numOfJars));
            while (fromJar.getBalls().isEmpty()) { // Keep selecting until we find a jar with balls
                fromJar = jarsArrayList.get(random.nextInt(numOfJars));
            }

            // Step 2: Find a non-full jar to push into (and not the same jar)
            Jar toJar = jarsArrayList.get(random.nextInt(numOfJars));
            while (toJar == fromJar || toJar.getBalls().size() >= 4) { // Avoid full jars or the same jar
                toJar = jarsArrayList.get(random.nextInt(numOfJars));
            }

            // Step 3: Move the ball using pop & push
            Ball ball = fromJar.removeBall(); // Pop from source jar
            toJar.addBall(ball); // Push into target jar
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
