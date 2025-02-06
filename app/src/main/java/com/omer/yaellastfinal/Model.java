package com.omer.yaellastfinal;

public class Model {
    private Jar[][] table;
    private int counter;
    private final int SIZE=7;

    public Model(){
        if(BallPuzzleGame.Difficulty.SUPEREASY) {table = new Jar[2][2];}
        else if(BallPuzzleGame.Difficulty.EASY) {table = new Jar[3][3];}
        else if(BallPuzzleGame.Difficulty.EASYMID) {table = new Jar[4][4];}
        else if(BallPuzzleGame.Difficulty.MEDIUM) {table = new Jar[5][5];}
        else if(BallPuzzleGame.Difficulty.HARD) {table = new Jar[6][6];}
        else if(BallPuzzleGame.Difficulty.EXTREME) {table = new Jar[7][7];}
    }
    public void startGame(){
        counter=0;

    }
    public gameOver(){
        int error=0;
        while(error==0){
            if (Jar)
        }

    }

}
