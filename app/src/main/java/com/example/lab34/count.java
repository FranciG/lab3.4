package com.example.lab34;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class count extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        Intent intent = getIntent();
        String tiempo = ((Intent) intent).getStringExtra("time");

       final TextView textView = findViewById(R.id.textView);
        textView.setText(tiempo);

//Creating the countdown, parsing the time typed, setting countdown to 1 second.
        new CountDownTimer(Integer.parseInt(tiempo)*1000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(""+ (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                textView.setText("Done!");
                alarm();
            }
        }.start();
    }

    private void alarm() {

        mediaPlayer = MediaPlayer.create(this, R.raw.elephant);
        mediaPlayer.start();
       

    }
}
