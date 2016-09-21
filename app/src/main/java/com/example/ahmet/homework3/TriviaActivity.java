package com.example.ahmet.homework3;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class TriviaActivity extends AppCompatActivity {

    private RadioGroup choicesRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        choicesRadioGroup = (RadioGroup) findViewById(R.id.radioGroupChoices);
    }

    private void addRadioButton(String radioButtonText){
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText(radioButtonText);
        choicesRadioGroup.addView(radioButton,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
