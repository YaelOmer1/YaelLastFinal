package com.omer.yaellastfinal;

import android.graphics.Bitmap;

public class ScoreList {
    private int score;
    private String level;
    private Bitmap bitmap;

    public ScoreList(int score, String level, Bitmap bitmap) {
        this.score = score;
        this.level = level;
        this.bitmap = bitmap;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Bitmap bitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}