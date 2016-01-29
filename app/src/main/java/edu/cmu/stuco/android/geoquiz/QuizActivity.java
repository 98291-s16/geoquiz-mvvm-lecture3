package edu.cmu.stuco.android.geoquiz;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.cmu.stuco.android.geoquiz.databinding.ActivityQuizBinding;

public class QuizActivity extends Activity  {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private QuizViewModel viewModel;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState put " + viewModel.getCurrentIndex());
        outState.putInt(KEY_INDEX, viewModel.getCurrentIndex());    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityQuizBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz);
        viewModel = new QuizViewModel(this);
        binding.setViewModel(viewModel);

        if (savedInstanceState != null) {
            int currentIndex = savedInstanceState.getInt(KEY_INDEX);
            Log.d(TAG, "onSaveInstanceState get " + currentIndex);
            viewModel.setCurrentIndex(currentIndex);
        }



    }


}
