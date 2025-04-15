package com.omer.yaellastfinal;

public class Controller {

    private BallPuzzleGame ballPuzzleGame;

    public Controller() {

        ballPuzzleGame = new BallPuzzleGame(Difficulty.EASY);
    }

    public void startGame() {

        ballPuzzleGame.startGame();
    }

    public BallPuzzleGame getBallPuzzleGame()
    {
        return ballPuzzleGame;
    }

//    public boolean gameover() {
//        return ballPuzzleGame.gameOver();
//    }

}
