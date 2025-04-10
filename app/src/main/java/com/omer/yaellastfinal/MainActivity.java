package com.omer.yaellastfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {
    private Ball LIGHTBLUE, LIGHTPINK, LIGHTPURPLE, PINK, PURPLE, YELLOW, RED, BLUE, GREEN, ORANGE;
    private Controller controller;
    private Jar jars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller();

        ImageButton restart = findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // אני צריכה לעשות שהכפתור יתחיל את התור מחדש
            }
        });

        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // אני צריכה שהכפתור יחזור צעד אחד אחורה
            }
        });

        startGame();

    }

    private void startGame() {
        controller.startGame();
        //BallPuzzleGame.startGame();
        Difficulty level = Difficulty.EASY; //TODO
//        \\תכנות דינאמי: שני לינארים עם ID
//                findviewbyid לכל אחד מהמ
//                באופן דינמי להוסיף מבחנות לפי ל LEVEL

    }

    //private void GameOver()




}