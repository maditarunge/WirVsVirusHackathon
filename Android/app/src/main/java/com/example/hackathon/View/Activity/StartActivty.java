package com.example.hackathon.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.R;

public class StartActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activty);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        new CountDownTimer(3000, 500) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                startActivity();
            }
        }.start();

    }

    private void startActivity()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
