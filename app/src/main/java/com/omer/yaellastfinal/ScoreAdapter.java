package com.omer.yaellastfinal;

import android.content.Context;

import com.google.android.material.color.utilities.Score;

import java.util.List;

public class ScoreAdapter {
    Context context;
    List<Score> object;

}

public ScoreAdapter(Context context, int resource, int textViewResourceId, List<Score> objects){
    super(context, resource, textViewResourceId, objects);
    this.context = context;
    this.object = objects;
}

