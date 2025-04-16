package com.omer.yaellastfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.omer.yaellastfinal.model.Ball;
import com.omer.yaellastfinal.model.Difficulty;
import com.omer.yaellastfinal.model.Jar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Ball LIGHTBLUE, LIGHTPINK, LIGHTPURPLE, PINK, PURPLE, YELLOW, RED, BLUE, GREEN, ORANGE;
    private Controller controller;
    private Jar jars;

    private MyCanvasView myCanvasView;

    private TextView levelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller();

        int level = getIntent().getIntExtra("level", 0);
        levelTextView = findViewById(R.id.levelTextView);
        levelTextView.setText("Level: " + level);

//        ImageButton restart = findViewById(R.id.restart);
//        restart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // אני צריכה לעשות שהכפתור יתחיל את התור מחדש
//            }
//        });
//
//        ImageButton back = findViewById(R.id.back);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // אני צריכה שהכפתור יחזור צעד אחד אחורה
//            }
//        });

        myCanvasView = findViewById(R.id.myCanvas);


        startGame();

    }

    private void startGame() {
        controller.startGame();
        List<Jar> jars =
            controller.getBallPuzzleGame().getJarsArrayList();

        //BallPuzzleGame.startGame();
        Difficulty level = Difficulty.EASY; //TODO
//        \\תכנות דינאמי: שני לינארים עם ID
//                findviewbyid לכל אחד מהמ
//                באופן דינמי להוסיף מבחנות לפי ל LEVEL

    }

    //private void GameOver()




}