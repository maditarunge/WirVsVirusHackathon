package com.example.hackathon.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.Consts;
import com.example.hackathon.Model.User;
import com.example.hackathon.R;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        TextView tvChangingFailed = findViewById(R.id.tvChangingFailed);
        tvChangingFailed.setVisibility(View.INVISIBLE);

        Button btnChange = findViewById(R.id.button_change);
        btnChange.setOnClickListener(changeListener);
    }

    private Button.OnClickListener changeListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            change();
        }
    };

    private void change()
    {
        EditText etOld = findViewById(R.id.etOldPassword);
        EditText etNew = findViewById(R.id.etNewPassword);
        EditText etConfirm = findViewById(R.id.etConfirmPassword);

        check(etOld.getText().toString(), etNew.getText().toString(), etConfirm.getText().toString());

    }

    private void check(String oldPassword, String newPassword, String confirmPassword)
    {
        TextView tvChangingFailed = findViewById(R.id.tvChangingFailed);
        boolean ok = false; //TODO MR 2020-03-27 1845: Add login control
//        Consts.user = Main.getUser(username);
        if (Consts.user != null && Consts.user.isActive() && Consts.user.getPassword().equals(User.encryptPass(oldPassword)) && newPassword.equals(confirmPassword))
        {
            ok = true;
        }
        if (ok || Consts.TestData.testVersion)
        {
            tvChangingFailed.setVisibility(View.INVISIBLE);
            finish();
        }
        else
        {
            tvChangingFailed.setVisibility(View.VISIBLE);
        }
    }
}
