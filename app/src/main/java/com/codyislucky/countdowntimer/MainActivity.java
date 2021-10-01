package com.codyislucky.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtTimer;
    TextView txtTimeElapsed;
    Button btnReset;

    private final long startTime = 50*1000;
    private final long interval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTimer = (TextView) findViewById(R.id.txt_timer);
        txtTimeElapsed = (TextView) findViewById(R.id.txt_time_elapsed);
        btnReset = (Button) findViewById(R.id.btn_reset);

        CountDownTimer countDownTimer = new CountDownTimer(startTime, interval) {
            @Override
            public void onTick(long l) {
                txtTimer.setText("Time: " + l / 1000);
                txtTimeElapsed.setText("Time elapsed: " + (startTime - l) / 1000);
            }

            @Override
            public void onFinish() {
                txtTimer.setText("TIMER FINISHED");
            }
        };
        countDownTimer.start();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });
    }
}