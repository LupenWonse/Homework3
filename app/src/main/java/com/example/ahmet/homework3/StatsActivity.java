/*
 Homwork 4
 StatsActiviy
 Akarsh Gupta     - 800969888
 Ahmet Gencoglu   - 800982227
*/

package com.example.ahmet.homework3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    public void quit(View view){
        Intent restartIntent = new Intent(this,MainActivity.class);
        restartIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(restartIntent);
    }

    public void tryAgain(View view){
        finish();
    }
}
