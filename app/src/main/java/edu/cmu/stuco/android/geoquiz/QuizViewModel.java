package edu.cmu.stuco.android.geoquiz;

import android.app.Activity;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

/**
 * Created by AndrewOrobator on 1/28/16.
 */
public class QuizViewModel {
    private final Activity activity;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };


    private int currentIndex = 0;
    public final ObservableInt currentQuestion= new ObservableInt(
            mQuestionBank[currentIndex].getQuestion()
    );

    public QuizViewModel(Activity activity) {
        this.activity = activity;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
        currentQuestion.set(mQuestionBank[currentIndex].getQuestion());
    }

    public final View.OnClickListener trueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkAnswer(true);
        }
    };

    public final View.OnClickListener falseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkAnswer(false);
        }
    };

    public final View.OnClickListener nextClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            currentIndex++;
            currentIndex = currentIndex % mQuestionBank.length;
            currentQuestion.set(mQuestionBank[currentIndex].getQuestion());
        }
    };

    private void checkAnswer(boolean userPressedTrue) {
        boolean answer = mQuestionBank[currentIndex].isAnswer();

        int messageResId;

        if  (userPressedTrue == answer) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(activity, messageResId, Toast.LENGTH_SHORT).show();

    }


}
