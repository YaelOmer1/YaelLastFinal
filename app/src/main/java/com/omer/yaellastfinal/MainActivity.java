package com.omer.yaellastfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.omer.yaellastfinal.model.Ball;
import com.omer.yaellastfinal.model.BallPuzzleGame;
import com.omer.yaellastfinal.model.Difficulty;
import com.omer.yaellastfinal.model.Jar;
import com.omer.yaellastfinal.view.MyCanvasView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Controller controller;
    private Jar jars;
    private MyCanvasView myCanvasView;
    private TextView tvLevel;
    private int level;


    private Button btnMonitor;

    private TextView tvMonitor;
    ImageButton btnSound, btnBack, btnReplay;
    SoundPool sp;
    int backgroundsound;
    boolean isSoundOn = false;
    int streamId = 0;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.level = getIntent().getIntExtra("level", 0);
        tvLevel = findViewById(R.id.tvLevel);
        tvLevel.setText("Level: " + this.level);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.goBackOneMove();
            }
        });

        tvMonitor = findViewById(R.id.tvMonitor);

        BallPuzzleGame game = new BallPuzzleGame(Difficulty.EASY);
        myCanvasView = findViewById(R.id.myCanvas);
        controller = new Controller(game, myCanvasView);
        myCanvasView.setController(controller);


        tvMonitor.setVisibility(View.GONE);

        btnMonitor = findViewById(R.id.btnMonitor);
        btnMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myCanvasView.getVisibility() == View.VISIBLE) {
                    tvMonitor.setVisibility(View.VISIBLE);
                    myCanvasView.setVisibility(View.GONE);
                }
                else {
                    tvMonitor.setVisibility(View.GONE);
                    myCanvasView.setVisibility(View.VISIBLE);
                }
            }
        });


        btnSound = (ImageButton)findViewById(R.id.btnSound);
        btnSound.setOnTouchListener(this);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            sp = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(aa)
                    .build();

        }
        else{
            sp = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);

        }

        backgroundsound = sp.load(this, R.raw.backgroundsound,1);



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


        btnReplay = findViewById(R.id.btnReplay);
        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // controller.startGame(level);
                controller.replayBallMoves();

            }
        });

        controller.startGame(level);
        StringBuilder msg = new StringBuilder();
        msg.append("Jars:\n");
        List<Jar> jars = controller.getBallPuzzleGame().getJarsList();
        for (Jar jar : jars)
        {
            msg.append(jar).append("\n\n");
        }
        tvMonitor.setText(msg);

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
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float f = 0.8f;
//
//        if (event.getAction() == MotionEvent.ACTION_UP) {
//            sp.play(backgroundsound, 1, 1, 0, 0, 1);
//            findViewById(R.id.sound).setAlpha(1f);
//            sound.setImageResource(R.drawable.soundon);
//
//        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            findViewById(R.id.sound).setAlpha(f);
//            sound.setImageResource(R.drawable.soundoff);
//        }
//
//        return true;    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f = (float) 0.8;

        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            view.setAlpha(1);

            if (view == btnSound) {
                if (!isSoundOn) {
                    // Start looping sound
                    streamId = sp.play(backgroundsound, 1, 1, 1, -1, 1);
                    btnSound.setImageResource(R.drawable.soundon);
                    isSoundOn = true;
                } else {
                    // Stop the sound
                    sp.stop(streamId);
                    btnSound.setImageResource(R.drawable.soundoff);
                    isSoundOn = false;
                }
            }
        }
        else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            view.setAlpha(f);
        }

        return true;
        }


}