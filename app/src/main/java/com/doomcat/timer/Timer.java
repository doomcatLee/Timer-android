package com.doomcat.timer;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Timer {

    public int seconds;
    public boolean running;
    public boolean wasRunning;

    public Timer(int s){
        seconds = s;
    }


    public void runTimer(final TextView v){
        final Handler handler = new Handler();
        handler.post(new Runnable(){

            @Override
            public void run() {
                int minutes = (seconds%3600)/60;
                int secs =  seconds%60;
                Log.d("mins", Integer.toString(minutes));
                Log.d("secs", Integer.toString(secs));
                String time = String.format("%02d:%02d", minutes, secs);
                v.setText(time);
                if (running){
                    seconds--;
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
