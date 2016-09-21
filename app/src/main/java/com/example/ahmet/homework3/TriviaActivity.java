package com.example.ahmet.homework3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TriviaActivity extends AppCompatActivity implements GetImageAsync.IImageDisplay {

    public static final String CORRECT_ANSWERS_KEY = "CORRECT";

    private int currentQuestion;
    private int correctQuestions = 0;

    private ArrayList<Question> questionsList;

    private TextView textQuestionNumber;
    private TextView textQuestionText;
    private ImageView imageQuestionImage;
    private ProgressBar progressImageLoading;
    private TextView textImageLoadingLabel;

    private RadioGroup choicesRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        choicesRadioGroup = (RadioGroup) findViewById(R.id.radioGroupChoices);
        textQuestionNumber = (TextView) findViewById(R.id.textQuestionNumber);
        textQuestionText = (TextView) findViewById(R.id.textQuestionText);
        imageQuestionImage = (ImageView) findViewById(R.id.imageQuestionImage);
        progressImageLoading = (ProgressBar) findViewById(R.id.progressImageLoading);
        textImageLoadingLabel = (TextView) findViewById(R.id.textImageLoading);

        if(getIntent().getSerializableExtra(MainActivity.QUESTION_ARRAY_KEY) != null){
            questionsList = (ArrayList<Question>) getIntent().getSerializableExtra(MainActivity.QUESTION_ARRAY_KEY);
            showQuestion(0);
        } else
        {
            // TODO TOAST
        }
    }

    private void showQuestion(int i) {

        imageQuestionImage.setImageBitmap(null);
        progressImageLoading.setVisibility(View.VISIBLE);
        textImageLoadingLabel.setVisibility(View.VISIBLE);


        Question question = questionsList.get(i);
        Log.d("test",question.choices.toString());
        textQuestionNumber.setText(Integer.toString(question.id + 1));
        textQuestionText.setText(question.text);

        // TODO double check if our layout is ok when we have many choices
        choicesRadioGroup.removeAllViews();
        for (String choice: question.choices) {
            addRadioButton(choice);
        }

        if (question.image != null){
            new GetImageAsync(this).execute(question.image);
        } else {
            imageQuestionImage.setImageResource(R.drawable.question_mark);
            progressImageLoading.setVisibility(View.INVISIBLE);
            textImageLoadingLabel.setVisibility(View.INVISIBLE);
        }
    }

    private void addRadioButton(String radioButtonText){
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText(radioButtonText);
        choicesRadioGroup.addView(radioButton,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void setImage(Bitmap image) {
        imageQuestionImage.setImageBitmap(image);
        progressImageLoading.setVisibility(View.INVISIBLE);
        textImageLoadingLabel.setVisibility(View.INVISIBLE);
    }

    public void nextQuestion(View view) {
        if(checkAnswer()) {
            correctQuestions++;
        }

        if (currentQuestion < questionsList.size() - 1) {
            currentQuestion++;
            showQuestion(currentQuestion);
        } else {
            Intent intent = new Intent(this, StatsActivity.class);
            intent.putExtra(CORRECT_ANSWERS_KEY,correctQuestions);
            startActivity(intent);
        }
    }

    public boolean checkAnswer(){
        int givenAnswer = choicesRadioGroup.indexOfChild(choicesRadioGroup.findViewById(choicesRadioGroup.getCheckedRadioButtonId())) + 1;

        if (questionsList.get(currentQuestion).answer == givenAnswer) {
            return true;
        } else {
            return false;
        }
    }
}
