package com.example.ahmet.homework3;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class TriviaActivity extends AppCompatActivity {

    private ArrayList<Question> questionsList;

    private RadioGroup choicesRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        choicesRadioGroup = (RadioGroup) findViewById(R.id.radioGroupChoices);

        if(getIntent().getSerializableExtra(MainActivity.QUESTION_ARRAY_KEY) != null){
            questionsList = (ArrayList<Question>) getIntent().getSerializableExtra(MainActivity.QUESTION_ARRAY_KEY);
        } else
        {
            // TODO TOAST
        }
    }

    private void addRadioButton(String radioButtonText){
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText(radioButtonText);
        choicesRadioGroup.addView(radioButton,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
