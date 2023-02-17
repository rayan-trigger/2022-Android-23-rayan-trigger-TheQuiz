package com.rondray.thequiz.Models;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rondray.thequiz.R;


public class MainActivity extends AppCompatActivity {

    private EditText main_player1_et;
    private EditText main_player2_et;
    private Button btStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStart = findViewById(R.id.bt_commencer);
        main_player1_et = findViewById(R.id.main_player1_et);
        main_player2_et = findViewById(R.id.main_player2_et);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                //showAbout();
                for (int i=0; i < 2; i++) {
                    Toast.makeText(getApplicationContext(), "Made by Rayan Rondez for the Android" +
                            " workshop at Ecole des Métiers Techniques at Porrentruy in " +
                            "Jura (Switzerland). 2022-2023", Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.help:
                //showHelp();
                for (int i=0; i < 2; i++){
                    Toast.makeText(getApplicationContext(), "Help toast is under construction. " +
                            "Please be patient.", Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.parametre:
                //showParametre();
            Intent activity_parametre = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(activity_parametre);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        btStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent activity_game = new Intent(MainActivity.this, GameActivity.class);
                startActivity(activity_game);
            }
        });

        main_player1_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (main_player1_et.getText().toString().trim().length() > 0 &&
                        main_player2_et.getText().toString().trim().length() > 0) {
                    btStart.setEnabled(true);
                } else {
                    btStart.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (main_player1_et.getText().toString().equals(main_player2_et.getText().toString())) {
                    main_player1_et.setError( "Please enter different names for " +
                            "each player.");
                }
            }
        });

        main_player2_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (main_player1_et.getText().toString().trim().length() > 0 &&
                        main_player2_et.getText().toString().trim().length() > 0) {
                    btStart.setEnabled(true);
                } else {
                    btStart.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (main_player1_et.getText().toString().equals
                        (main_player2_et.getText().toString())) {
                    main_player2_et.setError( "Please enter different names for " +
                            "each player.");
                }
            }
        });
    }
}