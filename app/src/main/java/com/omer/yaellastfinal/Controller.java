package com.omer.yaellastfinal;



import com.omer.yaellastfinal.model.BallPuzzleGame;
import com.omer.yaellastfinal.model.Difficulty;
import com.omer.yaellastfinal.view.MyCanvasView;

import android.os.Handler;
import android.os.Looper;

public class Controller {

    boolean backToStart = true;
    private Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable replayRunnable = new Runnable() {
        @Override
        public void run() {
            canvasView.invalidate();

            if (backToStart)
            {
                if (ballPuzzleGame.getStackCommands().isEmpty())
                {
                    backToStart = false;
                }

                ballPuzzleGame.goBackOneMove();
                canvasView.invalidate();
            }
            else
            {
                if (ballPuzzleGame.getStackCommandsReversed().isEmpty())
                {
                    backToStart = true;
                    return;
                }

                ballPuzzleGame.goForwardOneMove();
                canvasView.invalidate();
            }


            handler.postDelayed(this, 1000);
        }
    };

    private BallPuzzleGame ballPuzzleGame;
    private MyCanvasView canvasView;

    public Controller(BallPuzzleGame game,  MyCanvasView canvasView) {
        this.ballPuzzleGame = game;
        this.canvasView = canvasView;
    }

    public void startGame(int level) {

        ballPuzzleGame.startGame(level);
    }

    public void goBackOneMove()
    {
        ballPuzzleGame.goBackOneMove();
        canvasView.invalidate();
    }



    public void replayBallMoves()
    {
        handler.postDelayed(replayRunnable, 1000);
    }

    public BallPuzzleGame getBallPuzzleGame()
    {
        return ballPuzzleGame;
    }

//    public boolean gameover() {
//        return ballPuzzleGame.gameOver();
//    }

}
