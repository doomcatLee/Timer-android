package com.doomcat.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.startButton)
    Button mStartButton;

    @BindView(R.id.stopButton)
    Button mStopButton;

    @BindView(R.id.resetButton)
    Button mResetButton;

    @BindView(R.id.timeTextView)
    TextView mTime;

    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mStartButton.setOnClickListener(this);
        mStopButton.setOnClickListener(this);
        mResetButton.setOnClickListener(this);

        if (savedInstanceState != null){
            timer.seconds = savedInstanceState.getInt("seconds");
            timer.running = savedInstanceState.getBoolean("running");
        }
        timer.runTimer(mTime);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",timer.seconds);
        savedInstanceState.putBoolean("running",timer.running);
        savedInstanceState.putBoolean("wasRunning", timer.wasRunning);
    }

    @Override
    protected void onStop(){
        super.onStop();
        timer.wasRunning = timer.running;
        timer.running = false;
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (timer.wasRunning){
            timer.running = true;
        }
    }



    @Override
    public void onClick(View v) {
        if (v== mStartButton){
            timer.onClickStart(v);
        }

        if (v== mStopButton){
            timer.onClickStop(v);
        }

        if (v== mResetButton){
            timer.onClickReset(v);
        }
    }
}
