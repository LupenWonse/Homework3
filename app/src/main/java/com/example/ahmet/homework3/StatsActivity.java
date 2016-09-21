package com.example.ahmet.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    private ProgressBar progressCorrectPercentage;
    private TextView textCorrectPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        progressCorrectPercentage = (ProgressBar) findViewById(R.id.progressCorrectAnswers);
        textCorrectPercentage = (TextView) findViewById(R.id.textCorrectPercentage);

        int correctAnswers = 0;
        int questionsCount = 0;

        if (getIntent().getIntExtra(TriviaActivity.CORRECT_ANSWERS_KEY, -1) != -1) {
            correctAnswers = getIntent().getIntExtra(TriviaActivity.CORRECT_ANSWERS_KEY,-1);
            questionsCount = getIntent().getIntExtra(TriviaActivity.QUESTIONS_COUNT_KEY,-1);

            int percentage = (100 * correctAnswers) / questionsCount;

            progressCorrectPercentage.setIndeterminate(false);
            progressCorrectPercentage.setProgress(percentage);
            textCorrectPercentage.setText(Integer.toString(percentage) + "%");
        }


    }
}
