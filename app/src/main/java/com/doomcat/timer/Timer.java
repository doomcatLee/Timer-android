package com.doomcat.timer;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Timer {

    private int seconds = 0;
    private boolean running;


    public void runTimer(final TextView v){
        final Handler handler = new Handler();
        handler.post(new Runnable(){

            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs =  seconds%60;
                String time = String.format("%d:%02d:%02d",hours, minutes, secs);
                v.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onClickStart(View v){
        running = true;

    }

    public void onClickStop(View v){
        running = false;

    }

    public void onClickReset(View v){
        running = false;
        seconds = 0;

    }
}
