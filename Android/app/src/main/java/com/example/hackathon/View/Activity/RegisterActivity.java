package com.example.hackathon.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.R;

public class RegisterActivity extends AppCompatActivity {

    private View.OnClickListener onClickListenerRegister = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO MR 2020-04-14 1037: add implementation
            startProfileActivity();
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        Button btnRegister = findViewById(R.id.button_register);
        btnRegister.setOnClickListener(onClickListenerRegister);
    }

    private void startProfileActivity()
    {
        ProfileActivity.status = ProfileActivity.Status.ADD;
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
