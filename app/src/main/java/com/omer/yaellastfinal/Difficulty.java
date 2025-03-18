package com.omer.yaellastfinal;

public enum Difficulty {
    SUPEREASY(4, 2, 5),
    EASY(6, 4, 10),
    EASYMID(8, 6, 15),
    MEDIUM(10, 8, 20),
    HARD(12, 10, 25),
    EXTREME(14, 12, 30);

    private final int numOfJars;
    private final int numberOfColors;
    private final int numOfShuffles; // New field

    Difficulty(int numOfJars, int numberOfColors, int numOfShuffles) {
        this.numOfJars = numOfJars;
        this.numberOfColors = numberOfColors;
        this.numOfShuffles = numOfShuffles;
    }

    public int getNumOfJars() {
        return numOfJars;
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public int getNumOfShuffles() {
        return numOfShuffles;
    }
}
