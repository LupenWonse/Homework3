package com.example.ahmet.homework3;

import android.os.AsyncTask;
import android.util.Log;

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

    @Override
    protected ArrayList<Question> doInBackground(Void... params) {
        try {
            URL url = new URL(triviaUrlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ( (line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
//            return stringBuilder.toString();
            Log.d("test",stringBuilder.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO Parse JSON

        return null;
    }
}
