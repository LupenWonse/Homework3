package com.example.ahmet.homework3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ahmet on 20.09.2016.
 */

public class Question implements Serializable {
    public int id;
    public String text;
    public ArrayList<String> choices;
    public int answer;
    public String image;

    public Question(int id, String text, ArrayList<String> choices, int answer, String image) {
        this.id = id;
        this.text = text;
        this.choices = choices;
        this.answer = answer;
        this.image = image;
    }
}
