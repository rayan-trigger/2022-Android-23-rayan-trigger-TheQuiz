package com.rondray.thequiz.Models;

import android.database.Cursor;

import java.util.ArrayList;

public class questions {

    private String question;
    private int answer;

    public questions() {};

    public questions(String question, int answer) {
        this.question = question;
        this.answer = answer;
    }

    public questions (Cursor cursor) {
        question = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        answer = cursor.getInt(cursor.getColumnIndexOrThrow("answer"));
    }

    public String getQuestion() {return question;}

    public int isReponse() {return answer;}
}
