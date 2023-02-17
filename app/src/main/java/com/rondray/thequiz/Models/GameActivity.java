package com.rondray.thequiz.Models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rondray.thequiz.Controllers.QuestionManager;
import com.rondray.thequiz.R;

public class GameActivity extends AppCompatActivity {
    private TextView player1Score, player2Score;
    private Button bt_player1, bt_player2;

    Runnable questionRunnable = null;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        QuestionManager qManager = new QuestionManager(this);
        player1Score = findViewById(R.id.player1_score);
        player2Score = findViewById(R.id.player2_score);
    }
    @Override
    protected void onStart() {
        super.onStart();
        setCountDownTimer();
    }

    //Incrémentation du score du joueur 1
    protected void onClickBtPl1(View view) {
        String scorePl1 = player1Score.getText().toString();
        int scorePl1Int = Integer.parseInt(scorePl1 + 1);
        player1Score.setText(scorePl1Int);
    }
    //Incrémentation du score du joueur 2
    protected void onClickBtPl2(View view) {
        String scorePl2 = player2Score.getText().toString();
        int scorePl2Int = Integer.parseInt(scorePl2 + 1);
        player2Score.setText(scorePl2Int);
    }

    private void startQuestionIterative() {
        handler = new Handler();
        questionRunnable = new Runnable() {
            @Override
            public void run() {
                if (QuestionManager.isLastQuestion() == true){
                    //quitter la boucle
                    handler.removeCallbacks(this);
                    //Executer le code de fin de partie
                } else {
                    //Code pour demender et afficher une question
                    bt_player1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onClickBtPl1(v);
                        }
                    });

                    bt_player2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onClickBtPl2(v);
                        }
                    });

                    handler.postDelayed(this, 2000);
                }
            }
        };
        handler.postDelayed(questionRunnable,1000);
    }

    private void setCountDownTimer() {
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                
                //Afficher le temps restant

            }

            public void onFinish() {
                //Afficher le temps écoulé
                startQuestionIterative();
            }
        }.start();
    }
}
