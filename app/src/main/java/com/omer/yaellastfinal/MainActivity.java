package com.omer.yaellastfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Ball LIGHTBLUE, LIGHTPINK, LIGHTPURPLE, PINK, PURPLE, YELLOW, RED, BLUE, GREEN, ORANGE;
    private Jar jars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }





}