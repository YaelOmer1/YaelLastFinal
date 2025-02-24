package com.omer.yaellastfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class OpeningActivity extends AppCompatActivity {

    private TextView highScoreText, levelText;
    public static int level = 30; // Sample level value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        levelText = findViewById(R.id.levelText);

        levelText.setText("Level: " + level);


        ImageButton startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpeningActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        SharedPreferences preferences = getSharedPreferences("gamePrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("level", level);
        editor.apply();

        int highScore = preferences.getInt("highScore", 0); // Default to 0 if not found
        int level = preferences.getInt("level", 1); // Default to 1 if not found

    }
}