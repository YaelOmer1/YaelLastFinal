package com.omer.yaellastfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GameOver extends AppCompatActivity {

    private TextView highScoreText, levelText;
    private int highScore = 2000; // Sample high score value, you can load this from shared preferences or a database


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

//        highScoreText = findViewById(R.id.highScoreText);
//        levelText = findViewById(R.id.levelText);

        highScoreText.setText("High Score: " + highScore);

        int level = getIntent().getIntExtra("level", 0);

        levelText.setText("Level: " + level);

        SharedPreferences preferences = getSharedPreferences("gamePrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("highScore", highScore);

    }



    public void startOver(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();

    }
}
