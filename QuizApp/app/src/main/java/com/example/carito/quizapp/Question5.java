package com.example.carito.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
    }

    public void nextQuestion(View view) {

        int points = calculatePoints();
        //Retrieve the variable "total_points" from the previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            points = points + extras.getInt("total_points");
        }

        boolean validatedAnswer = validateAnswer();

        if (validatedAnswer == true) {

            Intent startNextQuestion = new Intent(this, ScoreActivity.class);
            startNextQuestion.putExtra("total_points", points);
            startActivity(startNextQuestion);
        }
    }

    private int calculatePoints() {
        //Variable que tiene la vista
        CheckBox checkbox1 = findViewById(R.id.checkbox_1);
        CheckBox checkbox2 = findViewById(R.id.checkbox_2);
        CheckBox checkbox3 = findViewById(R.id.checkbox_3);

        //Variable de puntos ganados
        int questionPoints = 0;

        //Condicion para calcular puntaje
        if(checkbox1.isChecked() && checkbox3.isChecked() && !checkbox2.isChecked()){
            questionPoints = 2;
        }
        else{
            questionPoints = 0;
        }

        //Devolver puntaje obtenido
        return questionPoints;

    }

    private boolean validateAnswer() {
        CheckBox checkbox1 = findViewById(R.id.checkbox_1);
        CheckBox checkbox2 = findViewById(R.id.checkbox_2);
        CheckBox checkbox3 = findViewById(R.id.checkbox_3);

        int checkboxSelected = 0;

        if (checkbox1.isChecked()) {
            checkboxSelected = checkboxSelected + 1;
        }
        if (checkbox2.isChecked()) {
            checkboxSelected = checkboxSelected + 1;
        }
        if (checkbox3.isChecked()) {
            checkboxSelected = checkboxSelected + 1;
        }

        if (checkboxSelected == 2) {
            return true;
        }
        else{
            Toast.makeText(this, getString(R.string.message_two_correct), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
