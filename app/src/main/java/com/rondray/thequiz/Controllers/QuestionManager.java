package com.rondray.thequiz.Controllers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rondray.thequiz.Models.TheQuizSQLite;
import com.rondray.thequiz.Models.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionManager {
    private List<questions> arrayQuestions;

    public QuestionManager(Context context){ arrayQuestions = initQuestionList(context); }

    public List<questions>getArrayQuestions(){ return arrayQuestions; }

    public questions getRandomQuestion(List<questions> questionsList){
        int randomIndex = getQuestionIndex(questionsList);
        questions randomQuestion = questionsList.get(randomIndex);
        questionsList.remove(randomIndex);
        return randomQuestion;}



    private int getQuestionIndex(List<questions> questionsList){
        Random rand = new Random();
        return rand.nextInt(questionsList.size());
    }

    public static boolean isLastQuestion(List<questions> questionsList){
        return questionsList.size() == 0;
    }

    private ArrayList<questions> initQuestionList(Context context){
        ArrayList<questions> initQuestion = new ArrayList<>();
        TheQuizSQLite helper = new TheQuizSQLite(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(true, "quiz", new String[]{"idQuiz", "question", "answer"}, null, null, null, null, "idQuiz", null);
        while (cursor.moveToNext()){
            initQuestion.add((questions) cursor);
        }
        cursor.close();
        db.close();

        return initQuestion;
    }

    public ArrayList<questions> getQuestions() {
        return (ArrayList<questions>) arrayQuestions;
    }
}
