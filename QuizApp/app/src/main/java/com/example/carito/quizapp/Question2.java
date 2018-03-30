package com.example.carito.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
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

            Intent startNextQuestion = new Intent(this, Question3.class);
            startNextQuestion.putExtra("total_points", points);
            startActivity(startNextQuestion);
        }
    }

    private int calculatePoints() {
        //Variable que tiene la vista, no necesito declarar la el boton 2
        RadioButton radioButton1 = findViewById(R.id.radio_button_1);

        //Variable de puntos ganados
        int questionPoints = 0;

        //Condicion para calcular puntaje
        if (radioButton1.isChecked()) {
            questionPoints = 2;
        } else {
            questionPoints = 0;
        }
        //Devolver puntaje obtenido
        return questionPoints;

    }

    private boolean validateAnswer() {
        RadioButton radioButton1 = findViewById(R.id.radio_button_1);
        RadioButton radioButton2 = findViewById(R.id.radio_button_2);

        int radiobuttonSelected = 0;

        if (radioButton1.isChecked()) {
            radiobuttonSelected = radiobuttonSelected + 1;
        }
        if (radioButton2.isChecked()) {
            radiobuttonSelected = radiobuttonSelected + 1;
        }
        if (radiobuttonSelected == 1) {
            return true;
        }
        else{
            Toast.makeText(this, getString(R.string.message_one_correct), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
