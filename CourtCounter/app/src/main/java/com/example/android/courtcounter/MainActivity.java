package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the reset button is clicked.
     */
    public void resetScore(View view) {
        int resetScore = 0;
        scoreTeamA = resetScore;
        scoreTeamB = resetScore;
        displayForTeamA(resetScore);
        displayForTeamB(resetScore);

    }

        /**
         * This method is called when the +1 button is clicked Team A.
         */

    public void AddOnePointsTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);

    }

    /**
     * This method is called when the +2 button is clicked Team A for tile.
     */
    public void AddTwoPointsTeamA_tile(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);

    }

    /**
     * This method is called when the +2 button is clicked Team A for pennant.
     */
    public void AddTwoPointsTeamA_pennant(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);

    }

    /**
     * This method is called when the +9 is clicked Team A.
     */
    public void AddNinePointsTeamA(View view) {
        scoreTeamA = scoreTeamA + 9;
        displayForTeamA(scoreTeamA);

    }

    /**
     * This method is called when the +1 button is clicked Team B.
     */
    public void AddOnePointsTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);

    }

    /**
     * This method is called when the +2 button is clicked Team B for tile.
     */
    public void AddTwoPointsTeamB_tile(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);

    }

    /**
     * This method is called when the +1 is clicked Team B for pennant.
     */
    public void AddTwoPointsTeamB_pennant(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);

    }

    /**
     * This method is called when the +9 is clicked Team B.
     */
    public void AddNinePointsTeamB(View view) {
        scoreTeamB = scoreTeamB + 9;
        displayForTeamB(scoreTeamB);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
