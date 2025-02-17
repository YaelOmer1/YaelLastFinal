package com.omer.yaellastfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
    }

    public void startOver(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();

    }
}
