package com.example.carito.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
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

            Intent startNextQuestion = new Intent(this, Question4.class);
            startNextQuestion.putExtra("total_points", points);
            startActivity(startNextQuestion);
        }
    }

    private int calculatePoints() {
        //Variable que tiene la vista
        EditText answerEditText = findViewById(R.id.answer_3);
        //Variable que tienes la respuesta en esa vista
        String answer = answerEditText.getText().toString();
        //Variable con la respuesta correcta
        String correctAnswer = "Correcta";
        //Variable de puntos ganados
        int questionPoints = 0;

        //Condicion para calcular puntaje
        if(answer.equals(correctAnswer)){
           questionPoints = 2;
        }
        else{
            questionPoints = 0;
        }

        //Devolver puntaje obtenido
        return questionPoints;

    }

    private boolean validateAnswer() {
        EditText answerEditText = findViewById(R.id.answer_3);
        String answerComplete = answerEditText.getText().toString();

        if (answerComplete.matches("")) {
            Toast.makeText(this, "You did not enter your answer", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }


}
