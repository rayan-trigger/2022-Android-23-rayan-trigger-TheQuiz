package com.rondray.thequiz.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TheQuizSQLite extends SQLiteOpenHelper{

    static String DB_NAME = "thequiz.db";
    static int DB_VERSION = 1;

    public TheQuizSQLite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateDatabase = "CREATE TABLE quiz (idQuizINTEGER PRIMARY KEY, " +
                "question TEXT, answer INTEGER);";
        db.execSQL(sqlCreateDatabase);
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (1, \"La capitale du Canada est Toronto ?\",0);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (2, \"Le fleuve le plus long du monde est l'Amazone'\",1);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (3, \"La république rauracienne est une république franco-suisse\",1);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (4, \"Le premier homme à marcher sur la lune est Neil Armstrong ?\",1);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (5, \"GPT veut dire: GUID Paramètre Table\",0);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (6, \"L'eau ça mouille\",1);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (7, \"Kratos veut dire dieu en grec ?\",0);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (8, \"Le premier homme à aller dans l'espace est Youri Gagarine ?\",1);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (9, \"Bill Gates est chevalier ?\",1);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (10, \"Elon Musk a-t-il fondé Tesla Motors ?\",0);");
        db.execSQL("INSERT INTO quiz (question, answer) VALUES (11, \"La courroie de distribution permet d'actionner et de sycroniser le vilebrequin, les arbres à cames, ect ?\",1);");
    }

    @Override //pour toutes modifications de la base de données
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
