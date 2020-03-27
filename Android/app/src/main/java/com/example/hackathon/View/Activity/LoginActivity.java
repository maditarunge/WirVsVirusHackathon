package com.example.hackathon.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hackathon.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        TextView tvLoginFailed = findViewById(R.id.tvLoginFailed);
        tvLoginFailed.setVisibility(View.INVISIBLE);

        Button btnLogin = findViewById(R.id.button_login);
        btnLogin.setOnClickListener(newEntryListener);
    }

    private Button.OnClickListener newEntryListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            login();
        }
    };

    private void login()
    {
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        TextView tvLoginFailed = findViewById(R.id.tvLoginFailed);

        boolean ok = true; //TODO MR 2020-03-27 1845: Add login control
        if (ok)
        {
            tvLoginFailed.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            tvLoginFailed.setVisibility(View.VISIBLE);
        }
    }
}
