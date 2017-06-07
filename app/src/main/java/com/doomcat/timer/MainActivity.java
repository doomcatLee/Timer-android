package com.doomcat.timer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        timer.runTimer(mTime);
        mStartButton.setOnClickListener(this);
        mStopButton.setOnClickListener(this);
        mResetButton.setOnClickListener(this);
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
