package com.omer.yaellastfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OpeningActivity extends AppCompatActivity {

    private TextView highScoreText, levelText;
    private Spinner spinnerDifficulty;
    int level = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        ImageButton startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpeningActivity.this, MainActivity.class);
                intent.putExtra("level", level);
                startActivity(intent);
            }
        });


        levelText = findViewById(R.id.levelText);
        levelText.setText("Level: " + level);


        spinnerDifficulty = findViewById(R.id.spinnerDifficulty);
        String[] items = {"Beginner", "Easy", "Medium", "Hard", "Extreme"};
        ArrayAdapter<String> adapter =
             new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapter);

        spinnerDifficulty.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String selected = adapterView.getItemAtPosition(i).toString();
                        Toast.makeText(OpeningActivity.this, "SELECTED: " + i + " " + l, Toast.LENGTH_SHORT).show();
                        TextView textView = (TextView) view;
                        textView.setTextSize(24);

                        level = (int) l+1;
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

        SharedPreferences preferences = getSharedPreferences("gamePrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("level", level);
        editor.apply();

        int highScore = preferences.getInt("highScore", 0);
        int level = preferences.getInt("level", 1);

    }

}