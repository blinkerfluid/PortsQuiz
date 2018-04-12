package com.example.android.portsquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quizScore = 0;
    String toastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getQuestion1Answer() {

        RadioButton radio1ButtonB = findViewById(R.id.radio1ButtonB);
        boolean isRadio1ButtonB = radio1ButtonB.isChecked();

        if (isRadio1ButtonB)
            quizScore++;
    }

    private void getQuestion2Answer() {

        RadioButton radio2ButtonA = findViewById(R.id.radio2ButtonA);
        boolean isRadio2ButtonA = radio2ButtonA.isChecked();

        if (isRadio2ButtonA)
            quizScore++;
    }

    private void getQuestion3Answer() {

        RadioButton radio3ButtonC = findViewById(R.id.radio3ButtonC);
        boolean isRadio3ButtonC = radio3ButtonC.isChecked();

        if (isRadio3ButtonC)
            quizScore++;
    }

    private void getQuestion4Answer() {
        CheckBox checkBox4a = findViewById(R.id.checkBox4a);
        boolean is4a = checkBox4a.isChecked();

        CheckBox checkBox4b = findViewById(R.id.checkBox4b);
        boolean is4b = checkBox4b.isChecked();

        CheckBox checkBox4c = findViewById(R.id.checkBox4c);
        boolean is4c = checkBox4c.isChecked();

        CheckBox checkBox4d = findViewById(R.id.checkBox4d);
        boolean is4d = checkBox4d.isChecked();

        if (is4a && is4b && !is4c && !is4d)
            quizScore++;
        }

    private void getQuestion5Answer() {
        EditText question5Answer = findViewById(R.id.question_5_answer);
        String portForHTTPS = question5Answer.getText().toString();

        if (portForHTTPS.contains("443"))
            quizScore++;
    }

    private void getToast() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        quizScore = 0;
    }

    public void submitQuiz(View view) {
        getQuestion1Answer();
        getQuestion2Answer();
        getQuestion3Answer();
        getQuestion4Answer();
        getQuestion5Answer();
        toastText = "You answered " + quizScore + " out of 5 questions correctly!";
        getToast();
    }
}