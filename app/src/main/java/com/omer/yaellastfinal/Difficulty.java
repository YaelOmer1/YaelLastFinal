package com.omer.yaellastfinal;

public enum Difficulty {
    SUPEREASY(4, 2, 5),
    EASY(6, 4, 10),
    MEDIUM(8, 6, 15),
    HARD(10, 8, 20),
    EXTREME(12, 10, 25);

    private final int numOfJars;
    private final int numberOfColors;
    private final int numOfShuffles; // New field

    Difficulty(int numOfJars, int numberOfColors, int numOfShuffles) {

        if (numberOfColors > numOfJars-2){
           numberOfColors=numOfJars-2;
        }
        if( numberOfColors < numOfJars-2){
            numberOfColors = numOfJars-2;
        }

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
