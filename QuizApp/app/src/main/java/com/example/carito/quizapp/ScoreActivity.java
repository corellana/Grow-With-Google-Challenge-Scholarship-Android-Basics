package com.example.carito.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String message = CreateScoreSummary();
        displayMessage(message);
    }

    /**
     * Generates the result of the quiz
     * @return message with final points.
     */

    private String CreateScoreSummary() {

        int points = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            points = extras.getInt("total_points");
        }
        String pointsMessage = "Your score is " + "<b>" + points +  "</b>" + " of 10 total points.";

        if(points == 10){
            pointsMessage += "<br/><br/>" + "All those hours of study have been worth it! Congrats!";
        }else{
            pointsMessage += "<br/><br/>" + "Practice a little more and you will see how these questions become very easy! You know you can do it!";
        }

        return pointsMessage;
    }

    /**
     * Show the result of the quiz
     */
    private void displayMessage(String message) {
        TextView messageScore = findViewById(R.id.message_score);
        messageScore.setText(Html.fromHtml(message));

    }

}

