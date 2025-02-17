package com.omer.yaellastfinal;

import android.media.Image;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class BallPuzzleGame {
    private List<Jar> jars;
    private int numberOfColors;
    private int numOfJars;
    private Image[][] board;
    private int counter;
    private final int SIZE;
    private Image jarImage;
    Image jarImage = new Image("jar.png");
    ImageView jarImageView = new ImageView(jarImage);




    private Difficulty difficulty;



    public BallPuzzleGame(Difficulty difficulty) {
        this.difficulty = difficulty;
        this.jars = new ArrayList<>();
        setDifficultyParameters();
    }



    SIZE= setDifficultyParameters().(numOfJars()/2);

    public BallPuzzleGame() {
        board = new char[2][SIZE];
    }



    public void startGame() {
        counter = 0;
        for (int i=0;i<SIZE;i++)
        {
            for(int k=0;k<SIZE;k++)
            {
                board[i][k]=jarImage;
            }
        }
    }


    public void initializeGame() {
        for (int i = 0; i < numOfJars; i++) {
            jars.add(new Jar());
        }


        List<Ball> allBalls = new ArrayList<>();
        for (int i = 0; i < numberOfColors; i++) {
            for (int j = 0; j < 4; j++) {
                allBalls.add(new Ball(Color.values()[i]));
            }
        }

        Collections.shuffle(allBalls);

        int index = 0;
        for (Jar jar : jars) {
            for (int j = 0; j < 4; j++) {
                if (index < allBalls.size()) {
                    jar.addBall(allBalls.get(index));
                    index++;
                }
            }
        }
    }

    private void shuffleBalls(List<Ball> allBalls) {
        int shuffleTimes = 0;
        switch (difficulty) {
            case SUPEREASY:
                numOfJars = 4;
                numberOfColors = 2;
                break;
            case EASY:
                numOfJars = 6;
                numberOfColors = 4;
                break;
            case EASYMID:
                numOfJars = 8;
                numberOfColors = 6;
                break;
            case MEDIUM:
                numOfJars = 10;
                numberOfColors = 8;
                break;
            case HARD:
                numOfJars = 12;
                numberOfColors = 10;
                break;

            case EXTREME:
                numOfJars = 14;
                numberOfColors = 12;
                break;
        }

        for (int i = 0; i < shuffleTimes; i++) {
            Collections.shuffle(allBalls);
        }
    }


    public List<Jar> getJars() {
        return jars;
    }



    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jars.size(); i++) {
            sb.append("Jar ").append(i + 1).append(": ").append(jars.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BallPuzzleGame game = new BallPuzzleGame(Difficulty.EXTREME);
        game.initializeGame();
        System.out.println(game);
    }
}
