package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int score = 0;

    /**
     * This method is called when the submit button is clicked
     * @param view
     */

    public void submitAnswer(View view) {


        // Figure out if the user wants the results to be emailed or shown in the app
        CheckBox willEmailCB = (CheckBox) findViewById(R.id.sendEmail);
        boolean willEmail = willEmailCB.isChecked();

        // TextView to contain the score and feedback
        TextView scoreBoar = (TextView) findViewById(R.id.scoreBoard);

        // Aggregated string that will be show the scores via email or in the app
        String scoreInfo = "Feedback: \n";

        // Checks if the answer for Question 1 is correct
        RadioButton answer1 = (RadioButton) findViewById(R.id.answerOneC);
        if (answer1.isChecked()){
            scoreInfo += "\nAnswer # 1 is correct.";
            score += 1;
        }else{
            scoreInfo += "\nAnswer # 1 is incorrect\n\t- The correct answer is a D major.";
        }

        // Checks if the answer for Question 2 is correct
        RadioButton answer2 = (RadioButton) findViewById(R.id.answerTwoB);
        if (answer2.isChecked()){
            score += 1;
            scoreInfo += "\nAnswer # 2 is correct.";
        }else{
            scoreInfo += "\nAnswer # 2 is incorrect\n\t- The correct answer is a minor chord.";
        }

        // Checks if the answer for Question 3 is correct
        RadioButton answer3 = (RadioButton) findViewById(R.id.answerThreeD);
        if (answer3.isChecked()){
            score += 1;
            scoreInfo += "\nAnswer # 3 is correct.";
        }else{
            scoreInfo += "\nAnswer # 3 is incorrect\n\t- The correct answer is a capo.";
        }

        // Checks if the answer for Question 4 is correct
        RadioButton answer4 = (RadioButton) findViewById(R.id.answerFourB);
        if (answer4.isChecked()){
            score += 1;
            scoreInfo += "\nAnswer # 4 is correct.";
        }else{
            scoreInfo += "\nAnswer # 4 is incorrect\n\t- The correct answer is an E minor.";
        }

        // Checks if the answer for Question 5 is correct
        EditText answer5 = (EditText) findViewById(R.id.answerEditText);
        String answer5Value = answer5.getText().toString();
        String lc_answer5Value = answer5Value.toLowerCase();

        if (lc_answer5Value.equals("slash")){
            score += 1;
            scoreInfo += "\nAnswer # 5 is correct\n\t- Slash is indeed the lead guitarist for GNR.";

        }else{
            scoreInfo += "\nAnswer # 5 is incorrect\n\t- Slash is the lead guitarist for GNR and not " + answer5Value + ".";
        }

        scoreInfo += "\n\nTotal Score is " + score + "/5.";

        // Checks if the results should be emailed or not
        if (willEmail == true){
            scoreBoar.setText("Your score and feedback will be emailed.");
            composeEmail("Guitar Quiz App Results" , scoreInfo);
            score = 0;
        }else{
            scoreBoar.setText(scoreInfo);
            score = 0;
        }



    }

    /**
     * This method passes the parameters to an email intent
     * @param subject
     * @param scoreInformation
     */
    private void composeEmail(String subject, String scoreInformation){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, scoreInformation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method resets all the answers to unchecked and blank
     * @param view
     */
    public void resetQuiz(View view) {
        score = 0;

        CheckBox willEmailCB = (CheckBox) findViewById(R.id.sendEmail);
        willEmailCB.setChecked(false);

        //Reset buttons for question 1
        RadioButton answer1a = (RadioButton) findViewById(R.id.answerOneA);
        answer1a.setChecked(false);
        RadioButton answer1b = (RadioButton) findViewById(R.id.answerOneB);
        answer1b.setChecked(false);
        RadioButton answer1c = (RadioButton) findViewById(R.id.answerOneC);
        answer1c.setChecked(false);
        RadioButton answer1d = (RadioButton) findViewById(R.id.answerOneD);
        answer1d.setChecked(false);

        //Reset buttons for question 2
        RadioButton answer2a = (RadioButton) findViewById(R.id.answerTwoA);
        answer2a.setChecked(false);
        RadioButton answer2b = (RadioButton) findViewById(R.id.answerTwoB);
        answer2b.setChecked(false);

        //Reset buttons for question 3
        RadioButton answer3a = (RadioButton) findViewById(R.id.answerThreeA);
        answer3a.setChecked(false);
        RadioButton answer3b = (RadioButton) findViewById(R.id.answerThreeB);
        answer3b.setChecked(false);
        RadioButton answer3c = (RadioButton) findViewById(R.id.answerThreeC);
        answer3c.setChecked(false);
        RadioButton answer3d = (RadioButton) findViewById(R.id.answerThreeD);
        answer3d.setChecked(false);

        //Reset buttons for question 4
        RadioButton answer4a = (RadioButton) findViewById(R.id.answerFourA);
        answer4a.setChecked(false);
        RadioButton answer4b = (RadioButton) findViewById(R.id.answerFourB);
        answer4b.setChecked(false);
        RadioButton answer4c = (RadioButton) findViewById(R.id.answerFourC);
        answer4c.setChecked(false);
        RadioButton answer4d = (RadioButton) findViewById(R.id.answerFourD);
        answer4d.setChecked(false);

        //Reset EditText to blank
        EditText answer5value = (EditText) findViewById(R.id.answerEditText);
        answer5value.setText("");

    }

}



