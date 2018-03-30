package com.example.carito.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String message = CreateScoreSummary();
        displayMessage(message);

    }

//    private String CreateScoreSummary() {
//
//        int points = 0;
//
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            points = extras.getInt("total_points");
//        }
//        String pointsMessage = "Your score is " + points + " of 10 total points.";
//
//        if(points == 10){
//            String pm2 = "You did a great job! Congrats!";
//        }
//
//        return pointsMessage;

        // idea 1

    private String CreateScoreSummary() {

        int points = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            points = extras.getInt("total_points");
        }
        String pointsMessage = "Your score is " + points + " of 10 total points.";

        if(points == 10){
            pointsMessage += "\n" + "You did a great job! Congrats!";
        }
        
        return pointsMessage;
    }

    private void displayMessage(String message) {
        TextView messageScore = findViewById(R.id.message_score);
        messageScore.setText(message);

    }

}

