package com.omer.yaellastfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.omer.yaellastfinal.model.Ball;
import com.omer.yaellastfinal.model.Difficulty;
import com.omer.yaellastfinal.model.Jar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Ball LIGHTBLUE, LIGHTPINK, LIGHTPURPLE, PINK, PURPLE, YELLOW, RED, BLUE, GREEN, ORANGE;
    private Controller controller;
    private Jar jars;
    private ImageButton back, restart, sound;
    private MyCanvasView myCanvasView;
    private TextView levelTextView;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        controller = new Controller();

        int level = getIntent().getIntExtra("level", 0);
        levelTextView = findViewById(R.id.levelTextView);

        levelTextView.setText("Level: " + level);

        myCanvasView = findViewById(R.id.myCanvas);


        myCanvasView.setLevel(level);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.backgroundsound);


        // empty jars = 2 always
        // tbd: jars = 4 + 2*difficulty
        // num_jars = 4 + 2*level

        // Example:
        // difficulty=1 (4 jars):
        //   level 1:  jars=4 mixes=5
        // difficulty=2 (6 jars):
        //   level 1;  jars=6 mixes=10
        //   level 2;  jars=6 mixes=15
        //   level 3:  jars=6 mixes=20
        // difficulty=2 (8 jars => 24 balls):
        //   level 1;  jars=8 mixes=25
        //   level 2;  jars=8 mixes=30
        //   level 3:  jars=8 mixes=35


        restart = findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // אני צריכה לעשות שהכפתור יתחיל את התור מחדש
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // אני צריכה שהכפתור יחזור צעד אחד אחורה
            }
        });

        ImageButton sound = findViewById(R.id.sound);
        mediaPlayer = MediaPlayer.create(this, R.raw.backgroundsound);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        sound.setImageResource(R.drawable.soundon);

        MediaPlayer finalMediaPlayer = mediaPlayer;
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    MediaPlayer.pause();
                    sound.setImageResource(R.drawable.soundoff);
                } else {
                    MediaPlayer.start();
                    sound.setImageResource(R.drawable.soundon);
                }

            }
        });

        controller.startGame();


//        private void startGame() {
//            new Controller().getBallPuzzleGame().startGame();
//            List<Jar> jars =
//                    new Controller().getBallPuzzleGame().getJarsArrayList();
//
//            Difficulty level = Difficulty.EASY; //TODO
////        \\תכנות דינאמי: שני לינארים עם ID
////                findviewbyid לכל אחד מהמ
////                באופן דינמי להוסיף מבחנות לפי ל LEVEL
//
//        }

        //private void GameOver()


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();

    }
}