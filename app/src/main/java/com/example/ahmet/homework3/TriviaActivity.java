package com.example.ahmet.homework3;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TriviaActivity extends AppCompatActivity {

    private ArrayList<Question> questionsList;

    private TextView textQuestionNumber;
    private TextView textQuestionText;

    private RadioGroup choicesRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        choicesRadioGroup = (RadioGroup) findViewById(R.id.radioGroupChoices);

        textQuestionNumber = (TextView) findViewById(R.id.textQuestionNumber);
        textQuestionText = (TextView) findViewById(R.id.textQuestionText);


        if(getIntent().getSerializableExtra(MainActivity.QUESTION_ARRAY_KEY) != null){
            questionsList = (ArrayList<Question>) getIntent().getSerializableExtra(MainActivity.QUESTION_ARRAY_KEY);
            showQuestion(0);
        } else
        {
            // TODO TOAST
        }
    }

    private void showQuestion(int i) {
        Question question = questionsList.get(i);

        textQuestionNumber.setText(Integer.toString(question.id + 1));
        textQuestionText.setText(question.text);

        // TODO double check if our layout is ok when we have many choices
        for (String choice: question.choices) {
            addRadioButton(choice);
        }

        if (question.image != null){
            // TODO Get the image with ASync Task
        } else {
            // TODO Load a default image
        }
    }

    private void addRadioButton(String radioButtonText){
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText(radioButtonText);
        choicesRadioGroup.addView(radioButton,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
