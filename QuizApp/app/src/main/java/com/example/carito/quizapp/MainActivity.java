package com.example.carito.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Start Quiz button is clicked.
     * @param view button Start Quiz
     */

    public void startQuiz(View view) {
        Intent startNewtActivity = new Intent(this, Question1.class);
        startActivity(startNewtActivity);
    }
}

