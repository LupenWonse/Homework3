package com.example.ahmet.homework3;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Ahmet on 20.09.2016.
 */
public class GetTriviaAsync extends AsyncTask<Void, Void, ArrayList<Question>> {

    private static final String triviaUrlString =
            "http://dev.theappsdr.com/apis/trivia_json/index.php";
    public TriviaMainActivity mainActivity;

    public GetTriviaAsync(TriviaMainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected ArrayList<Question> doInBackground(Void... params) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Question> questions = new ArrayList<>();

        int questionId;
        String questionText;
        String questionImage;
        ArrayList<String> questionChoices = new ArrayList<>();
        int questionAnswer;
        
        try {
            URL url = new URL(triviaUrlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ( (line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONObject response = new JSONObject(stringBuilder.toString());
            JSONArray responseQuestions = response.getJSONArray("questions");
            for (int question = 0; question < responseQuestions.length() ; ++question){
                JSONObject currentQuestion = responseQuestions.getJSONObject(question);
                questionId = currentQuestion.getInt("id");
                questionText = currentQuestion.getString("text");
                questionAnswer = currentQuestion.getJSONObject("choices").getInt("answer");
                JSONArray choices = currentQuestion.getJSONObject("choices").getJSONArray("choice");
                for (int index = 0; index < choices.length(); ++index){
                    questionChoices.add(choices.getString(index));
                }

                if (currentQuestion.has("image")){
                    questionImage = currentQuestion.getString("image");
                } else {
                    questionImage = null;
                }
                questions.add(new Question(questionId,questionText,questionChoices,questionAnswer,questionImage));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    protected void onPostExecute(ArrayList<Question> questions) {
        mainActivity.setTrivia(questions);
    }
}

interface TriviaMainActivity {
    void setTrivia(ArrayList<Question> questions);
}
