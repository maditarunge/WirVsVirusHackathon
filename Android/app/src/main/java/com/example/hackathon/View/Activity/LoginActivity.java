package com.example.hackathon.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.Consts;
import com.example.hackathon.Main;
import com.example.hackathon.Model.User;
import com.example.hackathon.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Consts.SharedPrefs.sharedPref = getPreferences(Context.MODE_PRIVATE);
        Consts.SharedPrefs.editor = Consts.SharedPrefs.sharedPref.edit();

        if (Consts.SharedPrefs.sharedPref.getBoolean(Consts.SharedPrefs.Values.STAY_LOGGED_IN, false))
        {
            check(Consts.SharedPrefs.sharedPref.getString(Consts.SharedPrefs.Values.USER, null), Consts.SharedPrefs.sharedPref.getString(Consts.SharedPrefs.Values.PASS, null));
        }

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

        check(etUsername.getText().toString(), etPassword.getText().toString());

    }

    private void check(String username, String password)
    {
        TextView tvLoginFailed = findViewById(R.id.tvLoginFailed);
        boolean ok = false; //TODO MR 2020-03-27 1845: Add login control
        Consts.user = Main.getUser(username);
        if (Consts.user != null && Consts.user.isActive() && Consts.user.getPassword().equals(User.encryptPass(password)))
        {
            ok = true;
            Consts.SharedPrefs.editor.putString(Consts.SharedPrefs.Values.USER, username);
            Consts.SharedPrefs.editor.putString(Consts.SharedPrefs.Values.PASS, password);
        }
        if (ok || Consts.TestData.testVersion)
        {
            tvLoginFailed.setVisibility(View.INVISIBLE);
            startNewActivity();
        }
        else
        {
            tvLoginFailed.setVisibility(View.VISIBLE);
        }
    }

    private void startNewActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
