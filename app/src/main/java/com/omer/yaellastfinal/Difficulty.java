package com.omer.yaellastfinal;

public enum Difficulty {
    SUPEREASY(4, 2), EASY(6, 4), EASYMID(8, 6), MEDIUM(10, 8), HARD(12, 10), EXTREME(14, 12);

    private final int numOfJars;
    private final int numberOfColors;

    Difficulty(int numOfJars, int numberOfColors) {
        this.numOfJars = numOfJars;
        this.numberOfColors = numberOfColors;
    }

    public int getNumOfJars() {
        return numOfJars;
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }
}