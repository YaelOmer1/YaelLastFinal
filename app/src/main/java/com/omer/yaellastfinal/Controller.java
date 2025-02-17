package com.omer.yaellastfinal;

public class Controller {

    private BallPuzzleGame ballPuzzleGame;

    public Controller() {
        ballPuzzleGame = new BallPuzzleGame();
    }

    public void startGame() {
        ballPuzzleGame.startGame();
    }


    public boolean gameover() {
        return ballPuzzleGame.gameOver();
    }

}
