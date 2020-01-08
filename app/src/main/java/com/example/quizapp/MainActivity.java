package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private TextView questionTextView;
    private ImageView nextButton;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
        new Question(R.string.question_amendments, false), //correct: 27
        new Question(R.string.question_constitution, true),
        new Question(R.string.question_declaration, true),
        new Question(R.string.question_independence_rights, true),
        new Question(R.string.question_religion, true),
        new Question(R.string.question_government, false),
        new Question(R.string.question_government_feds, false),
        new Question(R.string.question_government_senators, true),
        //and add more!
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.main_btn_false);
        trueButton  = findViewById(R.id.main_btn_true);
        questionTextView = findViewById(R.id.main_tv_question);
        nextButton = findViewById(R.id.main_img_next);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_false:
                Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT).show();
                break;

            case R.id.main_btn_true:
                Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
                break;

            case R.id.main_img_next:
                // go to next question
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion(); 
        }

    }

    private void updateQuestion(){
        Log.d("Current", "onClick: " + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }
}
