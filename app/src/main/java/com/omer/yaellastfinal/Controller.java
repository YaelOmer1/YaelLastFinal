package com.omer.yaellastfinal;

import com.omer.yaellastfinal.model.BallPuzzleGame;
import com.omer.yaellastfinal.model.Difficulty;

public class Controller {

    private BallPuzzleGame ballPuzzleGame;

    public Controller() {

        ballPuzzleGame = new BallPuzzleGame(Difficulty.EASY);
    }

    public void startGame(int level) {

        ballPuzzleGame.startGame(level);
    }

    public BallPuzzleGame getBallPuzzleGame()
    {
        return ballPuzzleGame;
    }

//    public boolean gameover() {
//        return ballPuzzleGame.gameOver();
//    }

}
