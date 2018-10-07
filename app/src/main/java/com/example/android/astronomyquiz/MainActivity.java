package com.example.android.astronomyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates Score For Question 1
     * @return score
     */
    public int questionOne() {
        RadioButton correctAnswer = findViewById(R.id.q_one_correct);
        if (correctAnswer.isChecked()) {
            score = 1;
        }
        else{
            score = 0;
        }
        return score;
    }

    /**
     * Calculates Score For Question 2
     * @return score
     */
    public int questionTwo() {
        CheckBox correctOne = findViewById(R.id.q_two_correct);
        CheckBox correctTwo = findViewById(R.id.q_two_correct2);
        CheckBox correctThree = findViewById(R.id.q_two_correct3);
        CheckBox correctFour = findViewById(R.id.q_two_correct4);
        CheckBox incorrectOne = findViewById(R.id.q_two_incorrect);
        CheckBox incorrectTwo = findViewById(R.id.q_two_incorrect2);
        CheckBox incorrectThree = findViewById(R.id.q_two_incorrect3);
        CheckBox incorrectFour = findViewById(R.id.q_two_incorrect4);

        if (correctOne.isChecked() && correctTwo.isChecked() && correctThree.isChecked() && correctFour.isChecked()){
            score = 1;
        }
        if (incorrectOne.isChecked() || incorrectTwo.isChecked() || incorrectThree.isChecked() || incorrectFour.isChecked()){
            score = 0;
        }
        return score;
    }

    /**
     * Calculates Score For Question 3
     * @return score
     */
    public int questionThree() {
        RadioButton correctAnswer = findViewById(R.id.q_three_correct);
        if (correctAnswer.isChecked()) {
            score = 1;
        }
        else{
            score = 0;
        }
        return score;
    }

    /**
     * Calculates Score For Question 4
     * @return score
     */
    public int questionFour() {
        RadioButton correctAnswer = findViewById(R.id.q_four_correct);
        if (correctAnswer.isChecked()) {
            score = 1;
        }
        else{
            score = 0;
        }
        return score;
    }

    /**
     * Calculates Score For Question 5
     * @return score
     */
    public int questionFive() {
        EditText correctAnswer = findViewById(R.id.spaceOrbitor);
        String text = correctAnswer.getText().toString();

        if (text.equalsIgnoreCase("Space Shuttle Columbia")) {
            score = 1;
        }
        else if (text.equalsIgnoreCase("Columbia")) {
            score = 1;
        }
        else {
            score = 0;
        }
        return score;
    }

    /**
     * Calculates Total Score
    **/
    public int calculateTotal (){
        int totalScore = questionOne() + questionTwo() + questionThree() + questionFour() + questionFive();
        return totalScore;
    }

    /**
     * Displays Total Score To User When Submit is clicked
     * @param v
     */
     public void submitQuiz(View v){
        int totalScore = calculateTotal();
         EditText nameField = (EditText) (findViewById(R.id. name_field));
         String name = nameField.getText().toString();

        if (totalScore <= 3){
            String message = "You Got " + totalScore + " Correct, Nice Try " +name;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
        else if (totalScore == 4) {
            String message = "You Got " + totalScore + " Correct, Not Bad " +name + "!";
            Toast.makeText(this, message , Toast.LENGTH_LONG).show();
        }
        else if (totalScore == 5) {
            String message = "You Got Them All Correct! Great Job " + name + "!";
            Toast.makeText(this, message , Toast.LENGTH_LONG).show();
        }
     }
}
