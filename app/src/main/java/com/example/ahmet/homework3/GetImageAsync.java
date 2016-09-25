/*
 Homwork 4
 Get Async Image Thread
 Akarsh Gupta     - 800969888
 Ahmet Gencoglu   - 800982227
*/


package com.example.ahmet.homework3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class GetImageAsync extends AsyncTask<String, Void, Bitmap> {
    public IImageDisplay imageDisplayer;

    public GetImageAsync(IImageDisplay imageDisplayer) {
        this.imageDisplayer = imageDisplayer;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL imageURL = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) imageURL.openConnection();
            Bitmap image = BitmapFactory.decodeStream(connection.getInputStream());
            return image;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageDisplayer.setImage(bitmap);
    }

    static interface IImageDisplay{
        void setImage(Bitmap image);
    }
}
