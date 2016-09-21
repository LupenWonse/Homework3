package com.example.ahmet.homework3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ahmet on 20.09.2016.
 */

public class Question implements Serializable {
    public String text;
    public ArrayList<String> choices;
    public int answer;
    public String image;
}
