/*
 Homwork 4
 Question Class
 Akarsh Gupta     - 800969888
 Ahmet Gencoglu   - 800982227
*/

package com.example.ahmet.homework3;

import java.io.Serializable;
import java.util.ArrayList;



public class Question implements Serializable {
    private int id;
    private String text;
    private ArrayList<String> choices;
    private int answer;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Question(int id, String text, ArrayList<String> choices, int answer, String image) {
        this.id = id;
        this.text = text;
        this.choices = choices;
        this.answer = answer;
        this.image = image;
    }
}
