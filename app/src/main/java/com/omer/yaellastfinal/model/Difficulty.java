package com.omer.yaellastfinal.model;

public enum Difficulty {
    SUPEREASY(4, 2, 5),
    EASY(6, 4, 10),
    MEDIUM(8, 6, 15),
    HARD(10, 8, 20),
    EXTREME(12, 10, 25);

    private int numOfJars;
    private final int numOfColors;
    private final int numOfShuffles;

    Difficulty(int numOfJars, int numOfColors, int numOfShuffles) {

        if (numOfColors > numOfJars-2){
           numOfColors=numOfJars-2;
        }
        if( numOfColors < numOfJars-2){
            numOfColors = numOfJars-2;
        }

        this.numOfJars = numOfJars;
        this.numOfColors = numOfColors;
        this.numOfShuffles = numOfShuffles;
    }

    public int getNumOfJars() {
        return this.numOfJars;
    }

    public int getNumOfColors() {
        return numOfColors;
    }

    public int getNumOfShuffles() {
        return numOfShuffles;
    }
}
