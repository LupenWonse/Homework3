package com.example.ahmet.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        int correctAnswers = 0;

        if (getIntent().getIntExtra(TriviaActivity.CORRECT_ANSWERS_KEY, -1) != -1) {
            correctAnswers = getIntent().getIntExtra(TriviaActivity.CORRECT_ANSWERS_KEY,-1);
        }

        Log.d("test",Integer.toString(correctAnswers));
    }
}
